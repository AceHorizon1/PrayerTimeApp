package com.prayertimes.app.api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Response

interface PrayerTimesApiService {
    @GET("v1/timings")
    suspend fun getPrayerTimes(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("method") method: Int = 3, // Muslim World League
        @Query("school") school: Int = 1, // Hanafi
        @Query("latitudeAdjustmentMethod") latitudeAdjustmentMethod: Int = 3, // Angle-based method
        @Query("adjustment") adjustment: Int = 1,
        @Query("month") month: Int? = null,
        @Query("year") year: Int? = null
    ): Response<PrayerTimesResponse>
    
    @GET("v1/timingsByCity")
    suspend fun getPrayerTimesByCity(
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int = 3,
        @Query("school") school: Int = 1,
        @Query("latitudeAdjustmentMethod") latitudeAdjustmentMethod: Int = 3,
        @Query("adjustment") adjustment: Int = 1,
        @Query("month") month: Int? = null,
        @Query("year") year: Int? = null
    ): Response<PrayerTimesResponse>
}

data class PrayerTimesResponse(
    val code: Int,
    val status: String,
    val data: PrayerTimesData
)

data class PrayerTimesData(
    val timings: Timings,
    val date: DateInfo,
    val meta: Meta
)

data class Timings(
    val Fajr: String,
    val Sunrise: String,
    val Dhuhr: String,
    val Asr: String,
    val Sunset: String,
    val Maghrib: String,
    val Isha: String,
    val Imsak: String? = null,
    val Midnight: String? = null,
    val Firstthird: String? = null,
    val Lastthird: String? = null
)

data class DateInfo(
    val readable: String,
    val timestamp: String,
    val gregorian: GregorianDate,
    val hijri: HijriDate
)

data class GregorianDate(
    val date: String,
    val format: String,
    val day: String,
    val weekday: Weekday,
    val month: Month,
    val year: String,
    val designation: Designation
)

data class HijriDate(
    val date: String,
    val format: String,
    val day: String,
    val weekday: Weekday,
    val month: Month,
    val year: String,
    val designation: Designation,
    val holidays: List<String>? = null
)

data class Weekday(
    val en: String,
    val ar: String
)

data class Month(
    val number: Int,
    val en: String,
    val ar: String
)

data class Designation(
    val abbreviated: String,
    val expanded: String
)

data class Meta(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val method: Method,
    val latitudeAdjustmentMethod: String,
    val midnightMode: String,
    val school: String,
    val offset: Map<String, Int>? = null
)

data class Method(
    val id: Int,
    val name: String,
    val params: MethodParams,
    val location: MethodLocation
)

data class MethodParams(
    val Fajr: Double,
    val Isha: Double
)

data class MethodLocation(
    val latitude: Double,
    val longitude: Double
) 