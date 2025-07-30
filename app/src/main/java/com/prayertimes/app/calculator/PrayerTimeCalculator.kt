package com.prayertimes.app.calculator

import android.location.Location
import android.util.Log
import java.util.*
import kotlin.math.*

class PrayerTimeCalculator {
    private val TAG = "PrayerTimeCalculator"

    // Prayer time calculation methods based on PrayTimes.js
    enum class CalculationMethod(val displayName: String, val fajrAngle: Double, val ishaAngle: Double) {
        MWL("Muslim World League", 18.0, 17.0),
        ISNA("Islamic Society of North America (ISNA)", 15.0, 15.0),
        EGYPT("Egyptian General Authority of Survey", 19.5, 17.5),
        MAKKAH("Umm Al-Qura University, Makkah", 18.5, 90.0), // isha is 90 minutes after maghrib
        KARACHI("University of Islamic Sciences, Karachi", 18.0, 18.0),
        TEHRAN("Institute of Geophysics, University of Tehran", 17.7, 14.0),
        JAFARI("Shia Ithna-Ashari, Leva Institute, Qum", 16.0, 14.0)
    }

    enum class AsrMethod {
        STANDARD, // Shafi`i, Maliki, Ja`fari, Hanbali
        HANAFI    // Hanafi
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

        val calendar = Calendar.getInstance().apply { time = date }
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val lat = location.latitude
        val lng = location.longitude
        val elv = location.altitude

        val jDate = julian(year, month, day) - lng / (15 * 24)
        val timeZone = getTimeZone(date)
        val dst = getDst(date)
        val tz = timeZone + (if (dst != 0.0) 1 else 0)

        val times = computeTimes(jDate, lat, lng, elv, tz, method, asrMethod)
        
        return PrayerTimes(
            fajr = parseTimeString(times["fajr"] ?: "", date),
            sunrise = parseTimeString(times["sunrise"] ?: "", date),
            dhuhr = parseTimeString(times["dhuhr"] ?: "", date),
            asr = parseTimeString(times["asr"] ?: "", date),
            maghrib = parseTimeString(times["maghrib"] ?: "", date),
            isha = parseTimeString(times["isha"] ?: "", date)
        ).also {
            Log.d(TAG, "Calculated prayer times: $it")
        }
    }

    private fun computeTimes(
        jDate: Double, 
        lat: Double, 
        lng: Double, 
        elv: Double, 
        tz: Double,
        method: CalculationMethod,
        asrMethod: AsrMethod
    ): Map<String, String> {
        // Default times
        var times = mapOf(
            "imsak" to 5.0,
            "fajr" to 5.0,
            "sunrise" to 6.0,
            "dhuhr" to 12.0,
            "asr" to 13.0,
            "sunset" to 18.0,
            "maghrib" to 18.0,
            "isha" to 18.0
        )

        // Main iterations
        for (i in 1..1) {
            times = computePrayerTimes(times, jDate, lat, elv, method, asrMethod)
        }

        times = adjustTimes(times, tz, lng, lat)
        
        return times.mapValues { (_, time) -> 
            getFormattedTime(time, "24h") 
        }
    }

    private fun computePrayerTimes(
        times: Map<String, Double>, 
        jDate: Double, 
        lat: Double, 
        elv: Double,
        method: CalculationMethod,
        asrMethod: AsrMethod
    ): Map<String, Double> {
        val dayPortion = times.mapValues { it.value / 24 }
        
        val fajrAngle = method.fajrAngle
        val ishaAngle = method.ishaAngle
        
        val imsak = sunAngleTime(fajrAngle - 2, dayPortion["imsak"] ?: 0.0, jDate, lat, elv, "ccw")
        val fajr = sunAngleTime(fajrAngle, dayPortion["fajr"] ?: 0.0, jDate, lat, elv, "ccw")
        val sunrise = sunAngleTime(0.833, dayPortion["sunrise"] ?: 0.0, jDate, lat, elv, "ccw")
        val dhuhr = midDay(dayPortion["dhuhr"] ?: 0.0, jDate)
        val asr = asrTime(if (asrMethod == AsrMethod.HANAFI) 2.0 else 1.0, dayPortion["asr"] ?: 0.0, jDate, lat, elv)
        val sunset = sunAngleTime(0.833, dayPortion["sunset"] ?: 0.0, jDate, lat, elv)
        val maghrib = sunAngleTime(0.0, dayPortion["maghrib"] ?: 0.0, jDate, lat, elv)
        val isha = if (method == CalculationMethod.MAKKAH) {
            maghrib + (90.0 / 60.0) // 90 minutes after maghrib
        } else {
            sunAngleTime(ishaAngle, dayPortion["isha"] ?: 0.0, jDate, lat, elv)
        }

        return mapOf(
            "imsak" to imsak,
            "fajr" to fajr,
            "sunrise" to sunrise,
            "dhuhr" to dhuhr,
            "asr" to asr,
            "sunset" to sunset,
            "maghrib" to maghrib,
            "isha" to isha
        )
    }

    private fun midDay(time: Double, jDate: Double): Double {
        val eqt = sunPosition(jDate + time).equation
        val noon = fixHour(12 - eqt)
        return noon
    }

    private fun sunAngleTime(angle: Double, time: Double, jDate: Double, lat: Double, elv: Double, direction: String = "cw"): Double {
        val decl = sunPosition(jDate + time).declination
        val noon = midDay(time, jDate)
        val latRad = dtr(lat)
        val declRad = dtr(decl)
        val angleRad = dtr(angle)
        
        val cosT = (-sin(angleRad) - sin(declRad) * sin(latRad)) / (cos(declRad) * cos(latRad))
        val clampedCosT = cosT.coerceIn(-1.0, 1.0)
        val t = arccos(clampedCosT) / 15.0
        
        return noon + (if (direction == "ccw") -t else t)
    }

    private fun asrTime(factor: Double, time: Double, jDate: Double, lat: Double, elv: Double): Double {
        val decl = sunPosition(jDate + time).declination
        val angle = -arccot(factor + tan(abs(lat - decl)))
        return sunAngleTime(angle, time, jDate, lat, elv)
    }

    private data class SunPosition(val declination: Double, val equation: Double)

    private fun sunPosition(jd: Double): SunPosition {
        val D = jd - 2451545.0
        val g = fixAngle(357.529 + (0.98560028 * D))
        val q = fixAngle(280.459 + (0.98564736 * D))
        val L = fixAngle(q + (1.915 * sin(g)) + (0.020 * sin(2.0 * g)))

        val R = 1.00014 - (0.01671 * cos(g)) - (0.00014 * cos(2.0 * g))
        val e = 23.439 - (0.00000036 * D)

        val RA = arctan2(cos(e) * sin(L), cos(L)) / 15.0
        val eqt = q / 15.0 - fixHour(RA)
        val decl = arcsin(sin(e) * sin(L))

        return SunPosition(decl, eqt)
    }

    private fun adjustTimes(times: Map<String, Double>, timeZone: Double, lng: Double, lat: Double): Map<String, Double> {
        var adjustedTimes = times.toMutableMap()
        
        // Adjust for timezone and longitude
        for (key in adjustedTimes.keys) {
            adjustedTimes[key] = adjustedTimes[key]!! + timeZone - lng / 15
        }

        return adjustedTimes
    }

    private fun getFormattedTime(time: Double, format: String): String {
        if (time.isNaN()) return "-----"
        if (format == "Float") return time.toString()
        
        val roundedTime = fixHour(time + 0.5 / 60) // add 0.5 minutes to round
        val hours = floor(roundedTime).toInt()
        val minutes = floor((roundedTime - hours) * 60).toInt()
        
        return when (format) {
            "24h" -> "${twoDigitsFormat(hours)}:${twoDigitsFormat(minutes)}"
            "12h" -> {
                val suffix = if (hours < 12) "am" else "pm"
                val hour12 = if (hours == 0) 12 else if (hours > 12) hours - 12 else hours
                "${hour12}:${twoDigitsFormat(minutes)} $suffix"
            }
            else -> "${twoDigitsFormat(hours)}:${twoDigitsFormat(minutes)}"
        }
    }

    private fun parseTimeString(timeStr: String, baseDate: Date): Date {
        if (timeStr == "-----") return baseDate
        
        val calendar = Calendar.getInstance().apply { time = baseDate }
        
        try {
            val timeParts = timeStr.split(":")
            val hour = timeParts[0].toInt()
            val minute = timeParts[1].split(" ")[0].toInt()
            
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing time string: $timeStr", e)
        }
        
        return calendar.time
    }

    // Utility functions
    private fun julian(year: Int, month: Int, day: Int): Double {
        var y = year
        var m = month
        if (m <= 2) {
            y -= 1
            m += 12
        }
        val A = floor(y / 100.0)
        val B = 2 - A + floor(A / 4.0)
        return floor(365.25 * (y + 4716)) + floor(30.6001 * (m + 1)) + day + B - 1524.5
    }

    private fun getTimeZone(date: Date): Double {
        val calendar = Calendar.getInstance().apply { time = date }
        return calendar.timeZone.getOffset(date.time) / (1000.0 * 60 * 60)
    }

    private fun getDst(date: Date): Double {
        val calendar = Calendar.getInstance().apply { time = date }
        return if (calendar.timeZone.useDaylightTime()) 1.0 else 0.0
    }

    // Math utility functions
    private fun dtr(d: Double): Double = (d * PI) / 180.0
    private fun rtd(r: Double): Double = (r * 180.0) / PI
    private fun sin(d: Double): Double = kotlin.math.sin(dtr(d))
    private fun cos(d: Double): Double = kotlin.math.cos(dtr(d))
    private fun tan(d: Double): Double = kotlin.math.tan(dtr(d))
    private fun arcsin(d: Double): Double = rtd(kotlin.math.asin(d))
    private fun arccos(d: Double): Double = rtd(kotlin.math.acos(d))
    private fun arctan(d: Double): Double = rtd(kotlin.math.atan(d))
    private fun arccot(x: Double): Double = rtd(kotlin.math.atan(1.0 / x))
    private fun arctan2(y: Double, x: Double): Double = rtd(kotlin.math.atan2(y, x))
    private fun fixAngle(a: Double): Double = fix(a, 360.0)
    private fun fixHour(a: Double): Double = fix(a, 24.0)
    private fun fix(a: Double, b: Double): Double {
        var result = a - b * floor(a / b)
        return if (result < 0) result + b else result
    }
    private fun twoDigitsFormat(num: Int): String = if (num < 10) "0$num" else num.toString()
} 