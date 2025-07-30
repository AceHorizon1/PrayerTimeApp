package com.prayertimes.app.api

import com.prayertimes.app.SettingsManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PrayerTimesRepository(private val settingsManager: SettingsManager) {
    private val api = PrayerTimesApiClient.service

    suspend fun getPrayerTimesForSelectedCity(): Result<PrayerTimesResponse> = withContext(Dispatchers.IO) {
        val city = settingsManager.selectedCity
        val lat = settingsManager.selectedCityLat
        val lng = settingsManager.selectedCityLng
        val country = city.substringAfterLast(", ", "")
        val cityName = city.substringBefore(",", city)
        return@withContext try {
            val response = if (city.isNotBlank() && country.isNotBlank()) {
                api.getPrayerTimesByCity(cityName, country)
            } else if (lat != 0.0 && lng != 0.0) {
                api.getPrayerTimes(lat, lng)
            } else {
                null
            }
            if (response != null && response.isSuccessful && response.body() != null) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception(response?.message() ?: "Unknown error"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
} 