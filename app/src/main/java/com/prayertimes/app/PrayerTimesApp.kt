package com.prayertimes.app

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.graphics.vector.ImageVector
import com.prayertimes.app.AdvancedSettingsScreen
import com.prayertimes.app.ui.theme.PrayerTimesTheme

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {
    object PrayerTimes : Screen("prayer_times", "Prayer Times", Icons.Filled.Schedule)
    object Settings : Screen("settings", "Settings", Icons.Filled.Settings)
    object AdvancedSettings : Screen("advanced_settings", "Advanced Settings", Icons.Filled.Settings)
}

@Composable
fun PrayerTimesApp() {
    val navController = rememberNavController()
    val context = LocalContext.current
    
    // Initialize managers
    val settingsManager = remember { SettingsManager(context) }
    val prayerTimesManager = remember { PrayerTimesManager(context) }
    
    // Make theme reactive to settings changes
    val darkTheme by remember { derivedStateOf { settingsManager.darkModeEnabled } }
    
    // Apply theme based on settings
    PrayerTimesTheme(darkTheme = darkTheme) {
        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController)
            }
        ) { innerPadding ->
            Box(modifier = Modifier.fillMaxSize()) {
                NavHost(
                    navController = navController,
                    startDestination = Screen.PrayerTimes.route
                ) {
                    composable(Screen.PrayerTimes.route) { 
                        PrayerTimesScreen(
                            prayerTimesManager = prayerTimesManager,
                            settingsManager = settingsManager
                        ) 
                    }
                    composable(Screen.Settings.route) { 
                        SettingsScreen(
                            prayerTimesManager = prayerTimesManager,
                            settingsManager = settingsManager,
                            navController = navController
                        ) 
                    }
                    composable(Screen.AdvancedSettings.route) { 
                        AdvancedSettingsScreen(
                            prayerTimesManager = prayerTimesManager,
                            settingsManager = settingsManager,
                            navController = navController
                        ) 
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(Screen.PrayerTimes, Screen.Settings)
    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(screen.icon, contentDescription = screen.label) },
                label = { Text(screen.label) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
} 