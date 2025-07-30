package com.prayertimes.app

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import com.prayertimes.app.ui.theme.PrayerTimesTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"
    private lateinit var prayerTimesManager: PrayerTimesManager
    private lateinit var settingsManager: SettingsManager
    private lateinit var locationManager: LocationManager
    
    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location) {
            Log.d(TAG, "Location changed in MainActivity: ${location.latitude}, ${location.longitude}")
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

    private val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        Log.d(TAG, "Location permissions result: $permissions")
        when {
            permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                Log.d(TAG, "Precise location permission granted")
                initializePrayerTimesManager()
            }
            permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                Log.d(TAG, "Approximate location permission granted")
                initializePrayerTimesManager()
            }
            else -> {
                Log.e(TAG, "No location permission granted")
                // Show a message to the user about the importance of location access
                Toast.makeText(
                    this,
                    "Location permission is required for accurate prayer times",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        
        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        settingsManager = SettingsManager(this)
        Log.d(TAG, "SettingsManager initialized")
        
        if (hasLocationPermission()) {
            Log.d(TAG, "Location permission already granted")
            initializePrayerTimesManager()
        } else {
            Log.d(TAG, "Requesting location permission")
            requestLocationPermission()
        }
        
        setContent {
            PrayerTimesTheme(darkTheme = settingsManager.darkModeEnabled) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val context = LocalContext.current
                    val scope = rememberCoroutineScope()
                    
                    // Initialize PrayerTimesManager if permissions are granted
                    LaunchedEffect(Unit) {
                        if (hasLocationPermission()) {
                            Log.d(TAG, "Initializing PrayerTimesManager from LaunchedEffect")
                            scope.launch {
                                initializePrayerTimesManager()
                            }
                        }
                    }
                    
                    // Cleanup when the composable is disposed
                    DisposableEffect(Unit) {
                        onDispose {
                            Log.d(TAG, "DisposableEffect: Cleaning up location updates")
                            try {
                                locationManager.removeUpdates(locationListener)
                            } catch (e: Exception) {
                                Log.e(TAG, "Error removing location updates in DisposableEffect", e)
                            }
                        }
                    }
                    
                    PrayerTimesApp()
                }
            }
        }
    }
    
    private fun hasLocationPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED ||
        ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }
    
    private fun requestLocationPermission() {
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }
    
    private fun initializePrayerTimesManager() {
        Log.d(TAG, "Initializing PrayerTimesManager")
        prayerTimesManager = PrayerTimesManager(this)
    }
    
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
        try {
            locationManager.removeUpdates(locationListener)
        } catch (e: Exception) {
            Log.e(TAG, "Error removing location updates", e)
        }
    }
}

 