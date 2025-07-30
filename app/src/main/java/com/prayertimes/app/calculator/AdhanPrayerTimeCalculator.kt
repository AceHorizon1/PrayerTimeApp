package com.prayertimes.app.calculator

import android.location.Location
import android.util.Log
import com.batoulapps.adhan.*
import com.batoulapps.adhan.data.DateComponents
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.*

class AdhanPrayerTimeCalculator {
    private val TAG = "AdhanPrayerTimeCalculator"

    // Prayer time calculation methods based on Adhan library
    enum class CalculationMethod(val displayName: String, val adhanMethod: com.batoulapps.adhan.CalculationMethod) {
        MWL("Muslim World League", com.batoulapps.adhan.CalculationMethod.MUSLIM_WORLD_LEAGUE),
        ISNA("Islamic Society of North America (ISNA)", com.batoulapps.adhan.CalculationMethod.NORTH_AMERICA),
        EGYPT("Egyptian General Authority of Survey", com.batoulapps.adhan.CalculationMethod.EGYPTIAN),
        MAKKAH("Umm Al-Qura University, Makkah", com.batoulapps.adhan.CalculationMethod.UMM_AL_QURA),
        KARACHI("University of Islamic Sciences, Karachi", com.batoulapps.adhan.CalculationMethod.KARACHI),
        DUBAI("Method used in UAE", com.batoulapps.adhan.CalculationMethod.DUBAI),
        QATAR("Modified version of Umm al-Qura used in Qatar", com.batoulapps.adhan.CalculationMethod.QATAR),
        KUWAIT("Method used by the country of Kuwait", com.batoulapps.adhan.CalculationMethod.KUWAIT),
        MOONSIGHTING("Moonsighting Committee", com.batoulapps.adhan.CalculationMethod.MOON_SIGHTING_COMMITTEE),
        SINGAPORE("Method used by Singapore", com.batoulapps.adhan.CalculationMethod.SINGAPORE)
    }

    enum class AsrMethod(val displayName: String, val adhanMadhab: com.batoulapps.adhan.Madhab) {
        STANDARD("Standard", com.batoulapps.adhan.Madhab.SHAFI), // Shafi`i, Maliki, Ja`fari, Hanbali
        HANAFI("Hanafi", com.batoulapps.adhan.Madhab.HANAFI)   // Hanafi
    }

    data class PrayerTimes(
        val fajr: Date,
        val sunrise: Date,
        val dhuhr: Date,
        val asr: Date,
        val maghrib: Date,
        val isha: Date
    )

    fun calculatePrayerTimes(
        location: Location,
        date: Date = Date(),
        method: CalculationMethod = CalculationMethod.MWL,
        asrMethod: AsrMethod = AsrMethod.STANDARD
    ): PrayerTimes {
        Log.d(TAG, "Calculating prayer times for location: ${location.latitude}, ${location.longitude}")
        Log.d(TAG, "Using calculation method: $method, Asr method: $asrMethod")

        try {
            // Create coordinates from location
            val coordinates = com.batoulapps.adhan.Coordinates(location.latitude, location.longitude)
            
            // Create date components
            val calendar = Calendar.getInstance()
            calendar.time = date
            val dateComponents = DateComponents(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH))
            
            // Create calculation parameters
            val parameters = method.adhanMethod.getParameters()
            parameters.madhab = asrMethod.adhanMadhab
            
            // Calculate prayer times using Adhan library
            val prayerTimes = com.batoulapps.adhan.PrayerTimes(coordinates, dateComponents, parameters)
            
            return PrayerTimes(
                fajr = prayerTimes.fajr,
                sunrise = prayerTimes.sunrise,
                dhuhr = prayerTimes.dhuhr,
                asr = prayerTimes.asr,
                maghrib = prayerTimes.maghrib,
                isha = prayerTimes.isha
            ).also {
                Log.d(TAG, "Calculated prayer times using Adhan library: $it")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error calculating prayer times with Adhan library, falling back to custom calculator", e)
            
            // Fallback to custom calculator
            val fallbackCalculator = PrayerTimeCalculator()
            val fallbackMethod = when (method) {
                CalculationMethod.MWL -> PrayerTimeCalculator.CalculationMethod.MWL
                CalculationMethod.ISNA -> PrayerTimeCalculator.CalculationMethod.ISNA
                CalculationMethod.EGYPT -> PrayerTimeCalculator.CalculationMethod.EGYPT
                CalculationMethod.KARACHI -> PrayerTimeCalculator.CalculationMethod.KARACHI
                CalculationMethod.MAKKAH -> PrayerTimeCalculator.CalculationMethod.MAKKAH
                CalculationMethod.DUBAI -> PrayerTimeCalculator.CalculationMethod.MWL // Fallback
                CalculationMethod.QATAR -> PrayerTimeCalculator.CalculationMethod.MWL // Fallback
                CalculationMethod.KUWAIT -> PrayerTimeCalculator.CalculationMethod.MWL // Fallback
                CalculationMethod.MOONSIGHTING -> PrayerTimeCalculator.CalculationMethod.MWL // Fallback
                CalculationMethod.SINGAPORE -> PrayerTimeCalculator.CalculationMethod.MWL // Fallback
            }
            
            val fallbackAsrMethod = when (asrMethod) {
                AsrMethod.STANDARD -> PrayerTimeCalculator.AsrMethod.STANDARD
                AsrMethod.HANAFI -> PrayerTimeCalculator.AsrMethod.HANAFI
            }

            val fallbackTimes = fallbackCalculator.calculatePrayerTimes(
                location = location,
                date = date,
                method = fallbackMethod,
                asrMethod = fallbackAsrMethod
            )

            return PrayerTimes(
                fajr = fallbackTimes.fajr,
                sunrise = fallbackTimes.sunrise,
                dhuhr = fallbackTimes.dhuhr,
                asr = fallbackTimes.asr,
                maghrib = fallbackTimes.maghrib,
                isha = fallbackTimes.isha
            ).also {
                Log.d(TAG, "Calculated prayer times using fallback calculator: $it")
            }
        }
    }

    // Helper method to get formatted time strings
    fun getFormattedPrayerTimes(
        location: Location,
        date: Date = Date(),
        method: CalculationMethod = CalculationMethod.MWL,
        asrMethod: AsrMethod = AsrMethod.STANDARD,
        timeZone: TimeZone = TimeZone.getDefault()
    ): Map<String, String> {
        val prayerTimes = calculatePrayerTimes(location, date, method, asrMethod)
        val formatter = SimpleDateFormat("HH:mm", Locale.getDefault()).apply {
            this.timeZone = timeZone
        }

        return mapOf(
            "fajr" to formatter.format(prayerTimes.fajr),
            "sunrise" to formatter.format(prayerTimes.sunrise),
            "dhuhr" to formatter.format(prayerTimes.dhuhr),
            "asr" to formatter.format(prayerTimes.asr),
            "maghrib" to formatter.format(prayerTimes.maghrib),
            "isha" to formatter.format(prayerTimes.isha)
        )
    }

    // Helper method to get prayer times with custom adjustments
    fun calculatePrayerTimesWithAdjustments(
        location: Location,
        date: Date = Date(),
        method: CalculationMethod = CalculationMethod.MWL,
        asrMethod: AsrMethod = AsrMethod.STANDARD,
        adjustments: Map<String, Int> = emptyMap()
    ): PrayerTimes {
        // For now, just use the regular calculation
        // TODO: Implement adjustments when Adhan library is properly integrated
        return calculatePrayerTimes(location, date, method, asrMethod)
    }



    // Helper method to get Sunnah times
    fun getSunnahTimes(
        location: Location,
        date: Date = Date(),
        method: CalculationMethod = CalculationMethod.MWL,
        asrMethod: AsrMethod = AsrMethod.STANDARD
    ): Map<String, Date> {
        try {
            // Create coordinates from location
            val coordinates = com.batoulapps.adhan.Coordinates(location.latitude, location.longitude)
            
            // Create date components
            val calendar = Calendar.getInstance()
            calendar.time = date
            val dateComponents = DateComponents(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH))
            
            // Create calculation parameters
            val parameters = method.adhanMethod.getParameters()
            parameters.madhab = asrMethod.adhanMadhab
            
            // Calculate prayer times using Adhan library
            val prayerTimes = com.batoulapps.adhan.PrayerTimes(coordinates, dateComponents, parameters)
            
            // Get Sunnah times using Adhan library
            val sunnahTimes = com.batoulapps.adhan.SunnahTimes(prayerTimes)
            
            return mapOf(
                "middleOfTheNight" to sunnahTimes.middleOfTheNight,
                "lastThirdOfTheNight" to sunnahTimes.lastThirdOfTheNight
            )
        } catch (e: Exception) {
            Log.e(TAG, "Error calculating Sunnah times with Adhan library, using manual calculation", e)
            
            // Fallback to manual calculation
            val prayerTimes = calculatePrayerTimes(location, date, method, asrMethod)
            
            // Calculate middle of the night and last third of the night
            val calendar = Calendar.getInstance()
            calendar.time = prayerTimes.maghrib
            val maghribTime = calendar.timeInMillis
            
            calendar.time = prayerTimes.fajr
            val fajrTime = calendar.timeInMillis
            
            val nightDuration = fajrTime - maghribTime
            val middleOfTheNight = Date(maghribTime + nightDuration / 2)
            val lastThirdOfTheNight = Date(maghribTime + (nightDuration * 2) / 3)
            
            return mapOf(
                "middleOfTheNight" to middleOfTheNight,
                "lastThirdOfTheNight" to lastThirdOfTheNight
            )
        }
    }
} 