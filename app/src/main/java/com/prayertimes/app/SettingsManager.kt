package com.prayertimes.app

import android.content.Context
import android.content.SharedPreferences

class SettingsManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    
    var calculationMethod: CalculationMethod
        get() = CalculationMethod.valueOf(prefs.getString(KEY_CALC_METHOD, CalculationMethod.MUSLIM_WORLD_LEAGUE.name) ?: CalculationMethod.MUSLIM_WORLD_LEAGUE.name)
        set(value) = prefs.edit().putString(KEY_CALC_METHOD, value.name).apply()
    
    var asrMethod: AsrMethod
        get() = AsrMethod.valueOf(prefs.getString(KEY_ASR_METHOD, AsrMethod.STANDARD.name) ?: AsrMethod.STANDARD.name)
        set(value) = prefs.edit().putString(KEY_ASR_METHOD, value.name).apply()
    
    var highLatitudeAdjustment: HighLatitudeAdjustment
        get() = HighLatitudeAdjustment.valueOf(prefs.getString(KEY_HIGH_LAT, HighLatitudeAdjustment.NONE.name) ?: HighLatitudeAdjustment.NONE.name)
        set(value) = prefs.edit().putString(KEY_HIGH_LAT, value.name).apply()
    
    var notificationsEnabled: Boolean
        get() = prefs.getBoolean(KEY_NOTIFICATIONS_ENABLED, true)
        set(value) = prefs.edit().putBoolean(KEY_NOTIFICATIONS_ENABLED, value).apply()
    
    var notificationOffset: Int
        get() = prefs.getInt(KEY_NOTIFICATION_OFFSET, 5)
        set(value) = prefs.edit().putInt(KEY_NOTIFICATION_OFFSET, value).apply()
    
    var darkModeEnabled: Boolean
        get() = prefs.getBoolean(KEY_DARK_MODE, false)
        set(value) = prefs.edit().putBoolean(KEY_DARK_MODE, value).apply()
    
    var selectedCity: String
        get() = prefs.getString(KEY_SELECTED_CITY, "") ?: ""
        set(value) = prefs.edit().putString(KEY_SELECTED_CITY, value).apply()
    
    var selectedCityLat: Double
        get() = prefs.getFloat(KEY_SELECTED_CITY_LAT, 0f).toDouble()
        set(value) = prefs.edit().putFloat(KEY_SELECTED_CITY_LAT, value.toFloat()).apply()
    
    var selectedCityLng: Double
        get() = prefs.getFloat(KEY_SELECTED_CITY_LNG, 0f).toDouble()
        set(value) = prefs.edit().putFloat(KEY_SELECTED_CITY_LNG, value.toFloat()).apply()
    
    var useApiForPrayerTimes: Boolean
        get() = prefs.getBoolean(KEY_USE_API, true)
        set(value) = prefs.edit().putBoolean(KEY_USE_API, value).apply()
    
    companion object {
        private const val PREFS_NAME = "prayer_times_settings"
        private const val KEY_CALC_METHOD = "calculation_method"
        private const val KEY_ASR_METHOD = "asr_method"
        private const val KEY_HIGH_LAT = "high_latitude_adjustment"
        private const val KEY_NOTIFICATIONS_ENABLED = "notifications_enabled"
        private const val KEY_NOTIFICATION_OFFSET = "notification_offset"
        private const val KEY_DARK_MODE = "dark_mode"
        private const val KEY_SELECTED_CITY = "selected_city"
        private const val KEY_SELECTED_CITY_LAT = "selected_city_lat"
        private const val KEY_SELECTED_CITY_LNG = "selected_city_lng"
        private const val KEY_USE_API = "use_api"
    }
} 