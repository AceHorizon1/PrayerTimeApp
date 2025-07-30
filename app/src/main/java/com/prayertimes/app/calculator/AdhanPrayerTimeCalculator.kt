package com.prayertimes.app.calculator

import android.location.Location
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class AdhanPrayerTimeCalculator {
    private val TAG = "AdhanPrayerTimeCalculator"

    // Prayer time calculation methods based on Adhan library
    enum class CalculationMethod(val displayName: String, val fajrAngle: Double, val ishaAngle: Double) {
        MWL("Muslim World League", 18.0, 17.0),
        ISNA("Islamic Society of North America (ISNA)", 15.0, 15.0),
        EGYPT("Egyptian General Authority of Survey", 19.5, 17.5),
        MAKKAH("Umm Al-Qura University, Makkah", 18.5, 90.0), // isha is 90 minutes after maghrib
        KARACHI("University of Islamic Sciences, Karachi", 18.0, 18.0),
        DUBAI("Method used in UAE", 18.2, 18.2),
        QATAR("Modified version of Umm al-Qura used in Qatar", 18.0, 90.0),
        KUWAIT("Method used by the country of Kuwait", 18.0, 17.5),
        MOONSIGHTING("Moonsighting Committee", 18.0, 18.0),
        SINGAPORE("Method used by Singapore", 20.0, 18.0)
    }

    enum class AsrMethod(val displayName: String) {
        STANDARD("Standard"), // Shafi`i, Maliki, Ja`fari, Hanbali
        HANAFI("Hanafi")   // Hanafi
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

        // For now, use the existing PrayerTimeCalculator as a fallback
        // until we properly integrate the Adhan library
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