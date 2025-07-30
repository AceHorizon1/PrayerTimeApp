package com.prayertimes.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\r\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u001e8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u000e\u0010\'\u001a\u00020(X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010*\u001a\u00020)2\u0006\u0010\u0005\u001a\u00020)8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020/8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020/8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u00102\"\u0004\b7\u00104R$\u00108\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b9\u0010\u0015\"\u0004\b:\u0010\u0017\u00a8\u0006<"}, d2 = {"Lcom/prayertimes/app/SettingsManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "Lcom/prayertimes/app/AsrMethod;", "asrMethod", "getAsrMethod", "()Lcom/prayertimes/app/AsrMethod;", "setAsrMethod", "(Lcom/prayertimes/app/AsrMethod;)V", "Lcom/prayertimes/app/CalculationMethod;", "calculationMethod", "getCalculationMethod", "()Lcom/prayertimes/app/CalculationMethod;", "setCalculationMethod", "(Lcom/prayertimes/app/CalculationMethod;)V", "", "darkModeEnabled", "getDarkModeEnabled", "()Z", "setDarkModeEnabled", "(Z)V", "Lcom/prayertimes/app/HighLatitudeAdjustment;", "highLatitudeAdjustment", "getHighLatitudeAdjustment", "()Lcom/prayertimes/app/HighLatitudeAdjustment;", "setHighLatitudeAdjustment", "(Lcom/prayertimes/app/HighLatitudeAdjustment;)V", "", "notificationOffset", "getNotificationOffset", "()I", "setNotificationOffset", "(I)V", "notificationsEnabled", "getNotificationsEnabled", "setNotificationsEnabled", "prefs", "Landroid/content/SharedPreferences;", "", "selectedCity", "getSelectedCity", "()Ljava/lang/String;", "setSelectedCity", "(Ljava/lang/String;)V", "", "selectedCityLat", "getSelectedCityLat", "()D", "setSelectedCityLat", "(D)V", "selectedCityLng", "getSelectedCityLng", "setSelectedCityLng", "useApiForPrayerTimes", "getUseApiForPrayerTimes", "setUseApiForPrayerTimes", "Companion", "app_debug"})
public final class SettingsManager {
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull
    public static final com.prayertimes.app.SettingsManager.Companion Companion = null;
    private static final java.lang.String PREFS_NAME = "prayer_times_settings";
    private static final java.lang.String KEY_CALC_METHOD = "calculation_method";
    private static final java.lang.String KEY_ASR_METHOD = "asr_method";
    private static final java.lang.String KEY_HIGH_LAT = "high_latitude_adjustment";
    private static final java.lang.String KEY_NOTIFICATIONS_ENABLED = "notifications_enabled";
    private static final java.lang.String KEY_NOTIFICATION_OFFSET = "notification_offset";
    private static final java.lang.String KEY_DARK_MODE = "dark_mode";
    private static final java.lang.String KEY_SELECTED_CITY = "selected_city";
    private static final java.lang.String KEY_SELECTED_CITY_LAT = "selected_city_lat";
    private static final java.lang.String KEY_SELECTED_CITY_LNG = "selected_city_lng";
    private static final java.lang.String KEY_USE_API = "use_api";
    
    public SettingsManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.prayertimes.app.CalculationMethod getCalculationMethod() {
        return null;
    }
    
    public final void setCalculationMethod(@org.jetbrains.annotations.NotNull
    com.prayertimes.app.CalculationMethod value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.prayertimes.app.AsrMethod getAsrMethod() {
        return null;
    }
    
    public final void setAsrMethod(@org.jetbrains.annotations.NotNull
    com.prayertimes.app.AsrMethod value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.prayertimes.app.HighLatitudeAdjustment getHighLatitudeAdjustment() {
        return null;
    }
    
    public final void setHighLatitudeAdjustment(@org.jetbrains.annotations.NotNull
    com.prayertimes.app.HighLatitudeAdjustment value) {
    }
    
    public final boolean getNotificationsEnabled() {
        return false;
    }
    
    public final void setNotificationsEnabled(boolean value) {
    }
    
    public final int getNotificationOffset() {
        return 0;
    }
    
    public final void setNotificationOffset(int value) {
    }
    
    public final boolean getDarkModeEnabled() {
        return false;
    }
    
    public final void setDarkModeEnabled(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSelectedCity() {
        return null;
    }
    
    public final void setSelectedCity(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final double getSelectedCityLat() {
        return 0.0;
    }
    
    public final void setSelectedCityLat(double value) {
    }
    
    public final double getSelectedCityLng() {
        return 0.0;
    }
    
    public final void setSelectedCityLng(double value) {
    }
    
    public final boolean getUseApiForPrayerTimes() {
        return false;
    }
    
    public final void setUseApiForPrayerTimes(boolean value) {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/prayertimes/app/SettingsManager$Companion;", "", "()V", "KEY_ASR_METHOD", "", "KEY_CALC_METHOD", "KEY_DARK_MODE", "KEY_HIGH_LAT", "KEY_NOTIFICATIONS_ENABLED", "KEY_NOTIFICATION_OFFSET", "KEY_SELECTED_CITY", "KEY_SELECTED_CITY_LAT", "KEY_SELECTED_CITY_LNG", "KEY_USE_API", "PREFS_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}