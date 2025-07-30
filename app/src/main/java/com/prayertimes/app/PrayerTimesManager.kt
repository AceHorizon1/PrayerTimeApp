package com.prayertimes.app

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.prayertimes.app.calculator.AdhanPrayerTimeCalculator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.math.*

class PrayerTimesManager(private val context: Context) {
    private val TAG = "PrayerTimesManager"
    private val locationManager: LocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    private var currentLocation: Location? = null
    private var calculationMethod: CalculationMethod = CalculationMethod.MUSLIM_WORLD_LEAGUE
    private var asrMethod: AsrMethod = AsrMethod.STANDARD
    private val calculator = AdhanPrayerTimeCalculator()
    private val scope = CoroutineScope(Dispatchers.IO)
    
    private val kaabaLocation = Location("").apply {
        latitude = 21.4225
        longitude = 39.8262
    }
    
    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.d(TAG, "Location updated: ${location.latitude}, ${location.longitude}")
            currentLocation = location
            scope.launch {
                updatePrayerTimes()
            }
        }
        
        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            Log.d(TAG, "Location provider status changed: $provider, status: $status")
        }
        
        override fun onProviderEnabled(provider: String) {
            Log.d(TAG, "Location provider enabled: $provider")
        }
        
        override fun onProviderDisabled(provider: String) {
            Log.d(TAG, "Location provider disabled: $provider")
        }
    }
    
    init {
        Log.d(TAG, "Initializing PrayerTimesManager")
        requestLocationUpdates()
    }
    
    private fun requestLocationUpdates() {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) 
            != PackageManager.PERMISSION_GRANTED) {
            Log.d(TAG, "Location permission not granted")
            return
        }

        try {
            // Try GPS first
            if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                Log.d(TAG, "Requesting GPS location updates")
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0L,
                    0f,
                    locationListener
                )
            }

            // Also try network provider
            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                Log.d(TAG, "Requesting network location updates")
                locationManager.requestLocationUpdates(
                    LocationManager.NETWORK_PROVIDER,
                    0L,
                    0f,
                    locationListener
                )
            }

            // Get last known location
            val lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                ?: locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            
            if (lastKnownLocation != null) {
                Log.d(TAG, "Got last known location: ${lastKnownLocation.latitude}, ${lastKnownLocation.longitude}")
                currentLocation = lastKnownLocation
                scope.launch {
                    updatePrayerTimes()
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error requesting location updates", e)
        }
    }
    
    suspend fun updatePrayerTimes(): List<PrayerTime> {
        val location = currentLocation
        if (location == null) {
            Log.d(TAG, "Cannot update prayer times - no location available")
            return emptyList()
        }
        
        Log.d(TAG, "Updating prayer times for location: ${location.latitude}, ${location.longitude}")
        return try {
            val times = calculator.calculatePrayerTimes(
                location = location,
                method = calculationMethod.toAdhanCalculatorMethod(),
                asrMethod = asrMethod.toAdhanAsrMethod()
            )

            listOf(
                PrayerTime("Fajr", times.fajr),
                PrayerTime("Sunrise", times.sunrise),
                PrayerTime("Dhuhr", times.dhuhr),
                PrayerTime("Asr", times.asr),
                PrayerTime("Maghrib", times.maghrib),
                PrayerTime("Isha", times.isha)
            ).also {
                Log.d(TAG, "Calculated prayer times using Adhan: $it")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error calculating prayer times", e)
            emptyList()
        }
    }
    

    
    fun setCalculationMethod(method: CalculationMethod) {
        calculationMethod = method
        scope.launch {
            updatePrayerTimes()
        }
    }
    
    fun setAsrMethod(method: AsrMethod) {
        asrMethod = method
        scope.launch {
            updatePrayerTimes()
        }
    }
    
    private fun CalculationMethod.toAdhanCalculatorMethod(): AdhanPrayerTimeCalculator.CalculationMethod {
        return when (this) {
            CalculationMethod.MUSLIM_WORLD_LEAGUE -> AdhanPrayerTimeCalculator.CalculationMethod.MWL
            CalculationMethod.ISNA -> AdhanPrayerTimeCalculator.CalculationMethod.ISNA
            CalculationMethod.EGYPTIAN -> AdhanPrayerTimeCalculator.CalculationMethod.EGYPT
            CalculationMethod.KARACHI -> AdhanPrayerTimeCalculator.CalculationMethod.KARACHI
            CalculationMethod.TEHRAN -> AdhanPrayerTimeCalculator.CalculationMethod.KARACHI // Fallback to Karachi
            CalculationMethod.SHIA -> AdhanPrayerTimeCalculator.CalculationMethod.KARACHI // Fallback to Karachi
            CalculationMethod.GULF -> AdhanPrayerTimeCalculator.CalculationMethod.DUBAI
            CalculationMethod.KUWAIT -> AdhanPrayerTimeCalculator.CalculationMethod.KUWAIT
            CalculationMethod.QATAR -> AdhanPrayerTimeCalculator.CalculationMethod.QATAR
            CalculationMethod.SINGAPORE -> AdhanPrayerTimeCalculator.CalculationMethod.SINGAPORE
            CalculationMethod.NORTH_AMERICA -> AdhanPrayerTimeCalculator.CalculationMethod.ISNA
            CalculationMethod.DUBAI -> AdhanPrayerTimeCalculator.CalculationMethod.DUBAI
            CalculationMethod.MOONSIGHTING -> AdhanPrayerTimeCalculator.CalculationMethod.MOONSIGHTING
        }
    }

    private fun AsrMethod.toAdhanAsrMethod(): AdhanPrayerTimeCalculator.AsrMethod {
        return when (this) {
            AsrMethod.STANDARD -> AdhanPrayerTimeCalculator.AsrMethod.STANDARD
            AsrMethod.HANAFI -> AdhanPrayerTimeCalculator.AsrMethod.HANAFI
        }
    }
}

data class SunPosition(
    val declination: Double,
    val equationOfTime: Double
) 