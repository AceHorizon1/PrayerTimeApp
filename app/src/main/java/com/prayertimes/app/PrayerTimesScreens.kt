package com.prayertimes.app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment as ComposeAlignment
import androidx.compose.ui.text.style.TextAlign as ComposeTextAlign
import androidx.compose.material3.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.runtime.derivedStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*
import kotlinx.coroutines.launch
import kotlin.math.abs
import com.prayertimes.app.data.City
import com.prayertimes.app.data.cities
import com.prayertimes.app.api.PrayerTimesRepository
import com.prayertimes.app.api.PrayerTimesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

data class PrayerTime(
    val name: String,
    val time: Date
)

@Composable
fun PrayerTimesScreen(
    prayerTimesManager: PrayerTimesManager? = null,
    settingsManager: SettingsManager? = null
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    var prayerTimes by remember { mutableStateOf<List<PrayerTime>>(emptyList()) }
    var nextPrayer by remember { mutableStateOf<PrayerTime?>(null) }
    var currentPrayer by remember { mutableStateOf<PrayerTime?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var locationStatus by remember { mutableStateOf<String>("Getting location...") }

    // Fetch prayer times using phone location
    LaunchedEffect(prayerTimesManager) {
        isLoading = true
        errorMessage = null
        locationStatus = "Getting location..."
        
        if (prayerTimesManager != null) {
            try {
                val times = prayerTimesManager.updatePrayerTimes()
                if (times.isNotEmpty()) {
                    prayerTimes = times
                    val now = Calendar.getInstance().time
                    val sortedTimes = times.sortedBy { it.time }
                    val next = sortedTimes.find { it.time > now }
                    val current = if (next != null) {
                        val index = sortedTimes.indexOf(next)
                        if (index > 0) sortedTimes[index - 1] else null
                    } else null
                    nextPrayer = next
                    currentPrayer = current
                    errorMessage = null
                    locationStatus = "Location-based prayer times"
                } else {
                    errorMessage = "Unable to calculate prayer times. Please check location permissions."
                    locationStatus = "Location unavailable"
                }
            } catch (e: Exception) {
                errorMessage = "Error calculating prayer times: ${e.message}"
                locationStatus = "Error getting location"
            }
        } else {
            errorMessage = "Prayer times manager not available."
            locationStatus = "Manager unavailable"
        }
        isLoading = false
    }
    
    // Show loading state if loading
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }
    
    // Show error state if there's an error
    if (errorMessage != null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = errorMessage!!,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp)
                )
                Button(
                    onClick = {
                        isLoading = true
                        errorMessage = null
                        scope.launch {
                            try {
                                prayerTimesManager?.let { manager ->
                                    val times = manager.updatePrayerTimes()
                                    if (times.isNotEmpty()) {
                                        val now = Calendar.getInstance().time
                                        val sortedTimes = times.sortedBy { it.time }
                                        val next = sortedTimes.find { it.time > now }
                                        val current = if (next != null) {
                                            val index = sortedTimes.indexOf(next)
                                            if (index > 0) sortedTimes[index - 1] else null
                                        } else null
                                        
                                        prayerTimes = times
                                        nextPrayer = next
                                        currentPrayer = current
                                        errorMessage = null
                                    } else {
                                        errorMessage = "Unable to fetch prayer times. Please check your location settings."
                                    }
                                }
                            } catch (e: Exception) {
                                errorMessage = "Error: ${e.message}"
                            } finally {
                                isLoading = false
                            }
                        }
                    }
                ) {
                    Text("Retry")
                }
            }
        }
        return
    }
    
    // Show empty state if no times available
    if (prayerTimes.isEmpty()) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "No prayer times available",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
        }
        return
    }
    
    // Show prayer times content
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        // Location Status
        item {
            LocationStatusCard(status = locationStatus)
        }
        
        // Next Prayer Card
        nextPrayer?.let { prayer ->
            item {
                NextPrayerCard(prayer = prayer)
            }
        }
        
        // Current Prayer Card
        currentPrayer?.let { prayer ->
            item {
                CurrentPrayerCard(prayer = prayer)
            }
        }
        
        // Prayer Times List
        items(prayerTimes) { prayer ->
            PrayerTimeItem(prayer = prayer)
        }
    }
}

@Composable
fun NextPrayerCard(prayer: PrayerTime) {
    var timeRemaining by remember { mutableStateOf("") }
    
    // Update time remaining every second
    LaunchedEffect(prayer) {
        while (true) {
            timeRemaining = formatTimeRemaining(prayer.time)
            kotlinx.coroutines.delay(1000) // Update every second
        }
    }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Next Prayer",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = prayer.name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = formatTime(prayer.time),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = timeRemaining,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

@Composable
fun CurrentPrayerCard(prayer: PrayerTime) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Current Prayer",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = prayer.name,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = formatTime(prayer.time),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
fun PrayerTimeItem(prayer: PrayerTime) {
    val isActive = isPrayerTimeActive(prayer)
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isActive) 3.dp else 1.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isActive) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = prayer.name,
                style = MaterialTheme.typography.titleMedium,
                color = if (isActive) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = formatTime(prayer.time),
                style = MaterialTheme.typography.titleMedium,
                color = if (isActive) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.primary
            )
        }
    }
}

private fun formatTime(date: Date): String {
    val formatter = SimpleDateFormat("h:mm a", Locale.getDefault())
    formatter.timeZone = TimeZone.getDefault()
    return formatter.format(date)
}

private fun formatTimeRemaining(targetTime: Date): String {
    val now = Calendar.getInstance().time
    val diff = targetTime.time - now.time
    
    if (diff <= 0) {
        return "Now"
    }
    
    val hours = diff / (1000 * 60 * 60)
    val minutes = (diff % (1000 * 60 * 60)) / (1000 * 60)
    
    return when {
        hours > 0 -> "${hours}h ${minutes}m"
        minutes > 0 -> "${minutes}m"
        else -> "Less than 1m"
    }
}

private fun isPrayerTimeActive(prayerTime: PrayerTime): Boolean {
    val now = Calendar.getInstance().time
    val diff = abs(prayerTime.time.time - now.time)
    // Consider prayer time active if within 10 minutes
    return diff <= 10 * 60 * 1000
}

@Composable
fun LocationStatusCard(status: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = Icons.Default.MyLocation,
                contentDescription = "Location Status",
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = status,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}



enum class CalculationMethod(val displayName: String) {
    MUSLIM_WORLD_LEAGUE("Muslim World League"),
    ISNA("Islamic Society of North America"),
    EGYPTIAN("Egyptian General Authority"),
    KARACHI("University of Islamic Sciences, Karachi"),
    TEHRAN("Institute of Geophysics, Tehran"),
    SHIA("Shia Ithna-Ashari"),
    GULF("Gulf Region"),
    KUWAIT("Kuwait"),
    QATAR("Qatar"),
    SINGAPORE("Singapore"),
    NORTH_AMERICA("Islamic Society of North America (ISNA)"),
    DUBAI("Dubai"),
    MOONSIGHTING("Moonsighting Committee Worldwide")
}

enum class AsrMethod(val displayName: String) {
    STANDARD("Standard"),
    HANAFI("Hanafi")
}

enum class HighLatitudeAdjustment(val displayName: String) {
    NONE("None"),
    MIDDLE_NIGHT("Middle of the Night"),
    ONE_SEVENTH("One Seventh"),
    ANGLE_BASED("Angle Based")
}

enum class TimeFormat(val displayName: String, val pattern: String) {
    TWELVE_HOUR("12-Hour (AM/PM)", "hh:mm a"),
    TWENTY_FOUR_HOUR("24-Hour", "HH:mm")
}

enum class DateFormat(val displayName: String, val pattern: String) {
    SHORT("Short (MM/DD)", "MM/dd"),
    MEDIUM("Medium (MMM DD)", "MMM dd"),
    LONG("Long (MMMM DD)", "MMMM dd"),
    FULL("Full (EEEE, MMMM DD)", "EEEE, MMMM dd")
}

enum class PrayerAdjustment(val displayName: String, val minutes: Int) {
    NONE("No Adjustment", 0),
    MINUS_5("5 minutes earlier", -5),
    MINUS_10("10 minutes earlier", -10),
    MINUS_15("15 minutes earlier", -15),
    PLUS_5("5 minutes later", 5),
    PLUS_10("10 minutes later", 10),
    PLUS_15("15 minutes later", 15)
}

enum class FajrAngle(val displayName: String, val angle: Double) {
    ANGLE_15("15° (ISNA)", 15.0),
    ANGLE_18("18° (MWL)", 18.0),
    ANGLE_18_5("18.5° (Umm Al-Qura)", 18.5),
    ANGLE_19_5("19.5° (Egyptian)", 19.5),
    ANGLE_20("20° (Singapore)", 20.0)
}

enum class IshaAngle(val displayName: String, val angle: Double) {
    ANGLE_15("15° (ISNA)", 15.0),
    ANGLE_17("17° (MWL)", 17.0),
    ANGLE_17_5("17.5° (Egyptian/Kuwait)", 17.5),
    ANGLE_18("18° (Karachi)", 18.0),
    ANGLE_90("90 minutes after Maghrib", 90.0)
}

enum class MaghribMethod(val displayName: String) {
    SUNSET("Sunset"),
    SUNSET_PLUS_3("Sunset + 3 minutes"),
    SUNSET_PLUS_5("Sunset + 5 minutes")
}

enum class DhuhrMethod(val displayName: String) {
    TRANSIT("Solar Transit (Standard)"),
    TRANSIT_PLUS_2("Transit + 2 minutes"),
    TRANSIT_PLUS_5("Transit + 5 minutes")
}

enum class AsrShadowLength(val displayName: String, val factor: Double) {
    SINGLE("Single Shadow (Shafi)", 1.0),
    DOUBLE("Double Shadow (Hanafi)", 2.0)
}

enum class TimeZonePreference(val displayName: String, val offset: Int) {
    LOCAL("Device Time Zone", 0),
    UTC("UTC", 0),
    EST("Eastern Time", -5),
    CST("Central Time", -6),
    MST("Mountain Time", -7),
    PST("Pacific Time", -8)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    prayerTimesManager: PrayerTimesManager? = null,
    settingsManager: SettingsManager? = null,
    navController: NavController? = null, // for navigation to advanced settings
    onDarkModeChanged: ((Boolean) -> Unit)? = null
) {
    var notificationsEnabled by remember { mutableStateOf(settingsManager?.notificationsEnabled ?: true) }
    
    // Use the current dark mode setting from SettingsManager
    val darkModeEnabled = settingsManager?.darkModeEnabled ?: false

    // Update settings when changed
    LaunchedEffect(notificationsEnabled) {
        settingsManager?.notificationsEnabled = notificationsEnabled
    }
    
    // Function to update dark mode setting
    fun updateDarkMode(enabled: Boolean) {
        settingsManager?.darkModeEnabled = enabled
        onDarkModeChanged?.invoke(enabled)
    }


    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                text = "Settings",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        // Notifications Section
        item {
            SettingsSection(title = "Notifications") {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Enable Prayer Time Notifications",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Switch(
                        checked = notificationsEnabled,
                        onCheckedChange = { notificationsEnabled = it }
                    )
                }
                // Only show notification offset if notifications are enabled
                if (notificationsEnabled) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Remind ${settingsManager?.notificationOffset ?: 5} minutes before",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Icon(Icons.Default.AccessTime, contentDescription = null)
                    }
                }
            }
        }
        // Location Section
        item {
            SettingsSection(title = "Location") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Using device location", style = MaterialTheme.typography.bodyLarge)
                    Icon(Icons.Default.MyLocation, contentDescription = "Device Location", tint = MaterialTheme.colorScheme.primary)
                }
                Text(
                    text = "Prayer times are calculated based on your current location",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
        // Dark Mode Section
        item {
            SettingsSection(title = "Appearance") {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Dark Mode", style = MaterialTheme.typography.bodyLarge)
                    Switch(
                        checked = darkModeEnabled,
                        onCheckedChange = { updateDarkMode(it) }
                    )
                }
            }
        }
        // Advanced Settings Button
        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { 
                        println("Advanced Settings button clicked!")
                        navController?.navigate("advanced_settings") {
                            launchSingleTop = true
                        }
                    },
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("Advanced Settings")
                }
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedSettingsScreen(
    prayerTimesManager: PrayerTimesManager? = null,
    settingsManager: SettingsManager? = null,
    navController: NavController? = null
) {
    println("AdvancedSettingsScreen is being called!")
    
    LaunchedEffect(Unit) {
        println("AdvancedSettingsScreen LaunchedEffect triggered!")
    }
    
    var calculationMethod by remember { mutableStateOf(settingsManager?.calculationMethod ?: CalculationMethod.MUSLIM_WORLD_LEAGUE) }
    var asrMethod by remember { mutableStateOf(settingsManager?.asrMethod ?: AsrMethod.STANDARD) }
    var highLatitudeAdjustment by remember { mutableStateOf(settingsManager?.highLatitudeAdjustment ?: HighLatitudeAdjustment.NONE) }
    var notificationOffset by remember { mutableStateOf(settingsManager?.notificationOffset ?: 5) }
    
    // Dropdown expanded states
    var calcDropdownExpanded by remember { mutableStateOf(false) }
    var asrDropdownExpanded by remember { mutableStateOf(false) }
    var highLatDropdownExpanded by remember { mutableStateOf(false) }
    
    // Update settings when changed
    LaunchedEffect(calculationMethod) {
        settingsManager?.calculationMethod = calculationMethod
        prayerTimesManager?.setCalculationMethod(calculationMethod)
    }
    
    LaunchedEffect(asrMethod) {
        settingsManager?.asrMethod = asrMethod
        prayerTimesManager?.setAsrMethod(asrMethod)
    }
    
    LaunchedEffect(highLatitudeAdjustment) {
        settingsManager?.highLatitudeAdjustment = highLatitudeAdjustment
    }
    
    LaunchedEffect(notificationOffset) {
        settingsManager?.notificationOffset = notificationOffset
    }
    
    Column(modifier = Modifier.fillMaxSize()) {
        // Top App Bar with Back Button
        TopAppBar(
            title = { Text("Advanced Settings") },
            navigationIcon = {
                IconButton(onClick = { navController?.navigateUp() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )
        
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            // Calculation Method Section
            item {
                SettingsSection(title = "Calculation Method") {
                    ExposedDropdownMenuBox(
                        expanded = calcDropdownExpanded,
                        onExpandedChange = { calcDropdownExpanded = !calcDropdownExpanded }
                    ) {
                        TextField(
                            value = calculationMethod.displayName,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Calculation Method") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = calcDropdownExpanded) },
                            modifier = Modifier.menuAnchor().fillMaxWidth()
                        )
                        ExposedDropdownMenu(
                            expanded = calcDropdownExpanded,
                            onDismissRequest = { calcDropdownExpanded = false }
                        ) {
                            CalculationMethod.values().forEach { method ->
                                DropdownMenuItem(
                                    text = { Text(method.displayName) },
                                    onClick = {
                                        calculationMethod = method
                                        calcDropdownExpanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            }
            
            // Asr Method Section
            item {
                SettingsSection(title = "Asr Method") {
                    ExposedDropdownMenuBox(
                        expanded = asrDropdownExpanded,
                        onExpandedChange = { asrDropdownExpanded = !asrDropdownExpanded }
                    ) {
                        TextField(
                            value = asrMethod.displayName,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Asr Method") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = asrDropdownExpanded) },
                            modifier = Modifier.menuAnchor().fillMaxWidth()
                        )
                        ExposedDropdownMenu(
                            expanded = asrDropdownExpanded,
                            onDismissRequest = { asrDropdownExpanded = false }
                        ) {
                            AsrMethod.values().forEach { method ->
                                DropdownMenuItem(
                                    text = { Text(method.displayName) },
                                    onClick = {
                                        asrMethod = method
                                        asrDropdownExpanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            }
            
            // High Latitude Adjustment Section
            item {
                SettingsSection(title = "High Latitude Adjustment") {
                    ExposedDropdownMenuBox(
                        expanded = highLatDropdownExpanded,
                        onExpandedChange = { highLatDropdownExpanded = !highLatDropdownExpanded }
                    ) {
                        TextField(
                            value = highLatitudeAdjustment.displayName,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("High Latitude Adjustment") },
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = highLatDropdownExpanded) },
                            modifier = Modifier.menuAnchor().fillMaxWidth()
                        )
                        ExposedDropdownMenu(
                            expanded = highLatDropdownExpanded,
                            onDismissRequest = { highLatDropdownExpanded = false }
                        ) {
                            HighLatitudeAdjustment.values().forEach { adjustment ->
                                DropdownMenuItem(
                                    text = { Text(adjustment.displayName) },
                                    onClick = {
                                        highLatitudeAdjustment = adjustment
                                        highLatDropdownExpanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            }
            
            // Notification Offset Section
            item {
                SettingsSection(title = "Notification Offset") {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Notify $notificationOffset minutes before",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Row {
                            IconButton(onClick = { if (notificationOffset > 0) notificationOffset -= 5 }) {
                                Icon(Icons.Default.Delete, "Decrease")
                            }
                            Text(
                                text = "$notificationOffset",
                                style = MaterialTheme.typography.bodyLarge
                            )
                            IconButton(onClick = { if (notificationOffset < 30) notificationOffset += 5 }) {
                                Icon(Icons.Default.Add, "Increase")
                            }
                        }
                    }
                }
            }
        }
    }
} 

@Composable
private fun SettingsSection(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            content()
        }
    }
} 