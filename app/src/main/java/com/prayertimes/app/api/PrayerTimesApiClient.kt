package com.prayertimes.app.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PrayerTimesApiClient {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.aladhan.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: PrayerTimesApiService = retrofit.create(PrayerTimesApiService::class.java)
} 