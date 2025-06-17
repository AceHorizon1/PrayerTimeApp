package com.prayertimes.app.calculator

import android.location.Location
import android.util.Log
import java.util.*
import kotlin.math.*

class PrayerTimeCalculator {
    private val TAG = "PrayerTimeCalculator"

    // Prayer time calculation methods
    enum class CalculationMethod(val fajrAngle: Double, val ishaAngle: Double) {
        MUSLIM_WORLD_LEAGUE(18.0, 17.0),
        ISNA(15.0, 15.0),
        EGYPTIAN(19.5, 17.5),
        KARACHI(18.0, 18.0),
        TEHRAN(17.7, 14.0),
        SHIA(16.0, 14.0),
        GULF(19.0, 22.0),
        KUWAIT(18.0, 17.5),
        QATAR(18.0, 18.0),
        SINGAPORE(20.0, 18.0),
        NORTH_AMERICA(15.0, 15.0),
        DUBAI(18.2, 18.2),
        MOONSIGHTING(18.0, 18.0)
    }

    enum class AsrMethod {
        STANDARD, // Shafi'i, Maliki, Hanbali
        HANAFI
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
        method: CalculationMethod = CalculationMethod.MUSLIM_WORLD_LEAGUE,
        asrMethod: AsrMethod = AsrMethod.STANDARD,
        highLatitudeAdjustment: com.prayertimes.app.HighLatitudeAdjustment = com.prayertimes.app.HighLatitudeAdjustment.NONE
    ): PrayerTimes {
        Log.d(TAG, "Calculating prayer times for location: ${location.latitude}, ${location.longitude}")
        Log.d(TAG, "Using calculation method: $method, Asr method: $asrMethod, High latitude adjustment: $highLatitudeAdjustment")

        val calendar = Calendar.getInstance().apply {
            time = date
        }

        // Get Julian date
        val julianDate = getJulianDate(calendar)
        Log.d(TAG, "Julian date: $julianDate")

        // Calculate sun position
        val sunPosition = calculateSunPosition(julianDate)
        Log.d(TAG, "Sun position - declination: ${sunPosition.declination}, equation of time: ${sunPosition.equationOfTime}")

        // Calculate prayer times
        var fajr = calculateTime(calendar, location, method.fajrAngle, sunPosition)
        val sunrise = calculateTime(calendar, location, 0.833, sunPosition) // Sunrise angle
        val dhuhr = calculateTime(calendar, location, 90.0, sunPosition) // Solar noon
        val asrAngle = if (asrMethod == AsrMethod.HANAFI) 120.0 else 105.0
        val asr = calculateTime(calendar, location, asrAngle, sunPosition)
        val maghrib = calculateTime(calendar, location, 0.833, sunPosition) // Sunset angle
        var isha = calculateTime(calendar, location, method.ishaAngle, sunPosition)

        // Apply high latitude adjustments
        if (highLatitudeAdjustment != com.prayertimes.app.HighLatitudeAdjustment.NONE) {
            val adjustedTimes = applyHighLatitudeAdjustment(
                location.latitude,
                fajr, sunrise, dhuhr, asr, maghrib, isha,
                highLatitudeAdjustment
            )
            fajr = adjustedTimes.first
            isha = adjustedTimes.second
        }

        return PrayerTimes(fajr, sunrise, dhuhr, asr, maghrib, isha).also {
            Log.d(TAG, "Calculated prayer times: $it")
        }
    }

    private fun getJulianDate(calendar: Calendar): Double {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1 // Calendar months are 0-based
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        var y = year
        var m = month
        if (m <= 2) {
            y -= 1
            m += 12
        }

        val a = floor(y / 100.0)
        val b = 2 - a + floor(a / 4.0)

        return floor(365.25 * (y + 4716)) + floor(30.6001 * (m + 1)) + day + b - 1524.5
    }

    private data class SunPosition(
        val declination: Double,
        val equationOfTime: Double
    )

    private fun calculateSunPosition(julianDate: Double): SunPosition {
        val n = julianDate - 2451545.0
        val L = 280.460 + 0.9856474 * n
        val g = 357.528 + 0.9856003 * n
        val λ = L + 1.915 * sin(g * PI / 180) + 0.020 * sin(2 * g * PI / 180)
        val ε = 23.439 - 0.0000004 * n

        val declination = asin(sin(ε * PI / 180) * sin(λ * PI / 180)) * 180 / PI
        val equationOfTime = -1.915 * sin(g * PI / 180) - 0.020 * sin(2 * g * PI / 180)

        return SunPosition(declination, equationOfTime)
    }

    private fun calculateTime(
        calendar: Calendar,
        location: Location,
        angle: Double,
        sunPosition: SunPosition
    ): Date {
        val lat = location.latitude * PI / 180
        val decl = sunPosition.declination * PI / 180
        val angleRad = angle * PI / 180

        val cosT = (sin(angleRad) - sin(lat) * sin(decl)) / (cos(lat) * cos(decl))
        
        // Handle cases where cosT is outside valid range
        val clampedCosT = cosT.coerceIn(-1.0, 1.0)
        val t = acos(clampedCosT) * 180 / PI

        val time = 12 + t / 15 - sunPosition.equationOfTime / 60 + location.longitude / 15
        val hours = floor(time)
        val minutes = (time - hours) * 60

        return Calendar.getInstance().apply {
            set(Calendar.YEAR, calendar.get(Calendar.YEAR))
            set(Calendar.MONTH, calendar.get(Calendar.MONTH))
            set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH))
            set(Calendar.HOUR_OF_DAY, hours.toInt())
            set(Calendar.MINUTE, minutes.toInt())
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            // Ensure we're using the local timezone
            timeZone = TimeZone.getDefault()
        }.time
    }

    private fun applyHighLatitudeAdjustment(
        latitude: Double,
        fajr: Date,
        sunrise: Date,
        dhuhr: Date,
        asr: Date,
        maghrib: Date,
        isha: Date,
        adjustment: com.prayertimes.app.HighLatitudeAdjustment
    ): Pair<Date, Date> {
        val absLatitude = abs(latitude)
        
        // Only apply adjustments for latitudes above 48 degrees
        if (absLatitude < 48) {
            return Pair(fajr, isha)
        }

        val calendar = Calendar.getInstance()
        val dayLength = maghrib.time - sunrise.time
        val nightLength = 24 * 60 * 60 * 1000 - dayLength

        return when (adjustment) {
            com.prayertimes.app.HighLatitudeAdjustment.MIDDLE_NIGHT -> {
                val midnight = Calendar.getInstance().apply {
                    time = dhuhr
                    add(Calendar.HOUR_OF_DAY, 12)
                }.time
                
                val fajrAdjustment = (nightLength / 2) - (fajr.time - maghrib.time)
                val ishaAdjustment = (nightLength / 2) - (sunrise.time - isha.time)
                
                val adjustedFajr = Date(fajr.time + fajrAdjustment)
                val adjustedIsha = Date(isha.time - ishaAdjustment)
                
                Pair(adjustedFajr, adjustedIsha)
            }
            
            com.prayertimes.app.HighLatitudeAdjustment.ONE_SEVENTH -> {
                val fajrAdjustment = nightLength / 7
                val ishaAdjustment = nightLength / 7
                
                val adjustedFajr = Date(fajr.time + fajrAdjustment)
                val adjustedIsha = Date(isha.time - ishaAdjustment)
                
                Pair(adjustedFajr, adjustedIsha)
            }
            
            com.prayertimes.app.HighLatitudeAdjustment.ANGLE_BASED -> {
                // For angle-based adjustment, we use fixed angles
                val fajrAngle = if (absLatitude >= 60) 19.0 else 18.0
                val ishaAngle = if (absLatitude >= 60) 18.0 else 17.0
                
                // Recalculate with adjusted angles
                val calendar = Calendar.getInstance().apply { time = dhuhr }
                val sunPosition = calculateSunPosition(getJulianDate(calendar))
                val location = Location("").apply { this.latitude = latitude }
                
                val adjustedFajr = calculateTime(calendar, location, fajrAngle, sunPosition)
                val adjustedIsha = calculateTime(calendar, location, ishaAngle, sunPosition)
                
                Pair(adjustedFajr, adjustedIsha)
            }
            
            com.prayertimes.app.HighLatitudeAdjustment.NONE -> Pair(fajr, isha)
        }
    }
} 