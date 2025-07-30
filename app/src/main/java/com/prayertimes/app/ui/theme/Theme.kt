package com.prayertimes.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = Color(0xFFD2BBA0), // nude primary
    onPrimary = Color(0xFF4E3B27),
    secondary = Color(0xFFE6CCB2),
    onSecondary = Color(0xFF4E3B27),
    background = Color(0xFFF8F3EF),
    onBackground = Color(0xFF4E3B27),
    surface = Color(0xFFFDF6F0),
    onSurface = Color(0xFF4E3B27)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFBFAE9C), // nude dark primary
    onPrimary = Color(0xFF3A2C1A),
    secondary = Color(0xFFA3907C),
    onSecondary = Color(0xFFF5E6D3),
    background = Color(0xFF3A2C1A),
    onBackground = Color(0xFFF8F3EF),
    surface = Color(0xFF4E3B27),
    onSurface = Color(0xFFF8F3EF)
)

@Composable
fun PrayerTimesTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
} 