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
        asrMethod: AsrMethod = AsrMethod.STANDARD
    ): PrayerTimes {
        Log.d(TAG, "Calculating prayer times for location: ${location.latitude}, ${location.longitude}")
        Log.d(TAG, "Using calculation method: $method, Asr method: $asrMethod")

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
        val fajr = calculateTime(calendar, location, method.fajrAngle, sunPosition)
        val sunrise = calculateTime(calendar, location, 0.833, sunPosition) // Sunrise angle
        val dhuhr = calculateTime(calendar, location, 90.0, sunPosition) // Solar noon
        val asrAngle = if (asrMethod == AsrMethod.HANAFI) 120.0 else 105.0
        val asr = calculateTime(calendar, location, asrAngle, sunPosition)
        val maghrib = calculateTime(calendar, location, 0.833, sunPosition) // Sunset angle
        val isha = calculateTime(calendar, location, method.ishaAngle, sunPosition)

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
        val t = acos(cosT) * 180 / PI

        val time = 12 + t / 15 - sunPosition.equationOfTime / 60
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
        }.time
    }
} 