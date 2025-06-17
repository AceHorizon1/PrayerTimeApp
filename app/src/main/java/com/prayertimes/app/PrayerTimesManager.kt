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
import com.prayertimes.app.calculator.PrayerTimeCalculator
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
    private var highLatitudeAdjustment: HighLatitudeAdjustment = HighLatitudeAdjustment.NONE
    private val calculator = PrayerTimeCalculator()
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
                method = calculationMethod.toCalculatorMethod(),
                asrMethod = if (asrMethod == AsrMethod.HANAFI) 
                    PrayerTimeCalculator.AsrMethod.HANAFI 
                else 
                    PrayerTimeCalculator.AsrMethod.STANDARD,
                highLatitudeAdjustment = highLatitudeAdjustment
            )

            listOf(
                PrayerTime("Fajr", times.fajr),
                PrayerTime("Sunrise", times.sunrise),
                PrayerTime("Dhuhr", times.dhuhr),
                PrayerTime("Asr", times.asr),
                PrayerTime("Maghrib", times.maghrib),
                PrayerTime("Isha", times.isha)
            ).also {
                Log.d(TAG, "Calculated prayer times: $it")
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error calculating prayer times", e)
            emptyList()
        }
    }
    
    fun calculateQiblaDirection(): Double? {
        val location = currentLocation ?: return null
        
        val lat1 = location.latitude * PI / 180
        val lon1 = location.longitude * PI / 180
        val lat2 = kaabaLocation.latitude * PI / 180
        val lon2 = kaabaLocation.longitude * PI / 180
        
        val y = sin(lon2 - lon1)
        val x = cos(lat1) * tan(lat2) - sin(lat1) * cos(lon2 - lon1)
        var qibla = atan2(y, x) * 180 / PI
        
        if (qibla < 0) {
            qibla += 360
        }
        
        return qibla
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
    
    fun setHighLatitudeAdjustment(adjustment: HighLatitudeAdjustment) {
        highLatitudeAdjustment = adjustment
        scope.launch {
            updatePrayerTimes()
        }
    }
    
    private fun CalculationMethod.toCalculatorMethod(): PrayerTimeCalculator.CalculationMethod {
        return when (this) {
            CalculationMethod.MUSLIM_WORLD_LEAGUE -> PrayerTimeCalculator.CalculationMethod.MUSLIM_WORLD_LEAGUE
            CalculationMethod.ISNA -> PrayerTimeCalculator.CalculationMethod.ISNA
            CalculationMethod.EGYPTIAN -> PrayerTimeCalculator.CalculationMethod.EGYPTIAN
            CalculationMethod.KARACHI -> PrayerTimeCalculator.CalculationMethod.KARACHI
            CalculationMethod.TEHRAN -> PrayerTimeCalculator.CalculationMethod.TEHRAN
            CalculationMethod.SHIA -> PrayerTimeCalculator.CalculationMethod.SHIA
            CalculationMethod.GULF -> PrayerTimeCalculator.CalculationMethod.GULF
            CalculationMethod.KUWAIT -> PrayerTimeCalculator.CalculationMethod.KUWAIT
            CalculationMethod.QATAR -> PrayerTimeCalculator.CalculationMethod.QATAR
            CalculationMethod.SINGAPORE -> PrayerTimeCalculator.CalculationMethod.SINGAPORE
            CalculationMethod.NORTH_AMERICA -> PrayerTimeCalculator.CalculationMethod.NORTH_AMERICA
            CalculationMethod.DUBAI -> PrayerTimeCalculator.CalculationMethod.DUBAI
            CalculationMethod.MOONSIGHTING -> PrayerTimeCalculator.CalculationMethod.MOONSIGHTING
        }
    }
}

data class SunPosition(
    val declination: Double,
    val equationOfTime: Double
) 