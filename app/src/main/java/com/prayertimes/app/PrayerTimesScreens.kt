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
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

data class PrayerTime(
    val name: String,
    val time: Date
)

@Composable
fun PrayerTimesScreen(
    prayerTimesManager: PrayerTimesManager? = null
) {
    var prayerTimes by remember { mutableStateOf<List<PrayerTime>>(emptyList()) }
    var nextPrayer by remember { mutableStateOf<PrayerTime?>(null) }
    var currentPrayer by remember { mutableStateOf<PrayerTime?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val scope = rememberCoroutineScope()
    
    // Initial load
    LaunchedEffect(Unit) {
        println("PrayerTimesScreen: Initial load")
        try {
            prayerTimesManager?.let { manager ->
                println("PrayerTimesScreen: Manager available, fetching times")
                val times = manager.updatePrayerTimes()
                println("PrayerTimesScreen: Received times: ${times.size}")
                
                if (times.isEmpty()) {
                    println("PrayerTimesScreen: No prayer times received")
                    errorMessage = "Unable to fetch prayer times. Please check your location settings."
                } else {
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
                    println("PrayerTimesScreen: Updated state with times")
                }
            } ?: run {
                println("PrayerTimesScreen: Manager is null")
                errorMessage = "Prayer times service is not available. Please restart the app."
            }
        } catch (e: Exception) {
            println("PrayerTimesScreen: Error loading times: ${e.message}")
            e.printStackTrace()
            errorMessage = "Error: ${e.message}"
        } finally {
            isLoading = false
        }
    }
    
    // Update prayer times every minute
    LaunchedEffect(prayerTimesManager) {
        println("PrayerTimesScreen: Starting periodic updates")
        while (true) {
            try {
                prayerTimesManager?.let { manager ->
                    println("PrayerTimesScreen: Updating times")
                    val times = manager.updatePrayerTimes()
                    println("PrayerTimesScreen: Received times: ${times.size}")
                    
                    if (times.isEmpty()) {
                        println("PrayerTimesScreen: No prayer times received during update")
                        errorMessage = "Unable to fetch prayer times. Please check your location settings."
                    } else {
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
                        println("PrayerTimesScreen: Updated state with times")
                    }
                } ?: run {
                    println("PrayerTimesScreen: Manager is null during update")
                    errorMessage = "Prayer times service is not available. Please restart the app."
                }
            } catch (e: Exception) {
                println("PrayerTimesScreen: Error updating times: ${e.message}")
                e.printStackTrace()
                errorMessage = "Error: ${e.message}"
            }
            kotlinx.coroutines.delay(60000) // 1 minute
        }
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
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
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
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = formatTime(prayer.time),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

private fun formatTime(date: Date): String {
    val formatter = SimpleDateFormat("h:mm a", Locale.getDefault())
    formatter.timeZone = TimeZone.getDefault()
    return formatter.format(date)
}

@Composable
fun QiblaScreen(
    prayerTimesManager: PrayerTimesManager? = null
) {
    var heading by remember { mutableStateOf(0f) }
    var qiblaDirection by remember { mutableStateOf(0f) }
    var accuracy by remember { mutableStateOf(0f) }
    
    // Request location permissions and start compass updates
    LaunchedEffect(prayerTimesManager) {
        // TODO: Implement actual compass sensor updates
        // For now, using placeholder values for heading
        heading = 0f
        
        // Get Qibla direction from manager
        prayerTimesManager?.calculateQiblaDirection()?.let { direction ->
            qiblaDirection = direction.toFloat()
        }
        
        // Placeholder accuracy
        accuracy = 5f
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Compass View
        Box(
            modifier = Modifier
                .size(250.dp)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            // Compass Circle
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = MaterialTheme.colorScheme.surface,
                        shape = CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.outline,
                        shape = CircleShape
                    )
            )
            
            // Cardinal Points
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                listOf("N", "E", "S", "W").forEachIndexed { index, point ->
                    Text(
                        text = point,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier
                            .offset(y = (-120).dp)
                            .rotate(index * 90f)
                    )
                }
            }
            
            // Qibla Arrow
            Icon(
                imageVector = Icons.Default.ArrowUpward,
                contentDescription = "Qibla Direction",
                modifier = Modifier
                    .size(40.dp)
                    .rotate(qiblaDirection - heading),
                tint = MaterialTheme.colorScheme.primary
            )
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        // Accuracy Indicator
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Accuracy",
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Accuracy: ${accuracy.toInt()}°",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Instructions
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hold your device flat",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Point the top of your device towards the arrow",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = "The arrow will point towards the Kaaba",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    prayerTimesManager: PrayerTimesManager? = null,
    settingsManager: SettingsManager? = null
) {
    var calculationMethod by remember { mutableStateOf(settingsManager?.calculationMethod ?: CalculationMethod.MUSLIM_WORLD_LEAGUE) }
    var asrMethod by remember { mutableStateOf(settingsManager?.asrMethod ?: AsrMethod.STANDARD) }
    var highLatitudeAdjustment by remember { mutableStateOf(settingsManager?.highLatitudeAdjustment ?: HighLatitudeAdjustment.NONE) }
    var notificationsEnabled by remember { mutableStateOf(settingsManager?.notificationsEnabled ?: true) }
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
        prayerTimesManager?.setHighLatitudeAdjustment(highLatitudeAdjustment)
    }
    
    LaunchedEffect(notificationsEnabled) {
        settingsManager?.notificationsEnabled = notificationsEnabled
    }
    
    LaunchedEffect(notificationOffset) {
        settingsManager?.notificationOffset = notificationOffset
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
                
                if (notificationsEnabled) {
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