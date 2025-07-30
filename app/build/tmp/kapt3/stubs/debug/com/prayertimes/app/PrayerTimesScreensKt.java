package com.prayertimes.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0007\u001a \u0010\u0010\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u001aD\u0010\u0011\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0013H\u0007\u001a#\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\r2\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00010\u0018\u00a2\u0006\u0002\b\u0019H\u0003\u001a\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002\u001a\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001cH\u0002\u001a\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\nH\u0002\u00a8\u0006!"}, d2 = {"AdvancedSettingsScreen", "", "prayerTimesManager", "Lcom/prayertimes/app/PrayerTimesManager;", "settingsManager", "Lcom/prayertimes/app/SettingsManager;", "navController", "Landroidx/navigation/NavController;", "CurrentPrayerCard", "prayer", "Lcom/prayertimes/app/PrayerTime;", "LocationStatusCard", "status", "", "NextPrayerCard", "PrayerTimeItem", "PrayerTimesScreen", "SettingsScreen", "onDarkModeChanged", "Lkotlin/Function1;", "", "SettingsSection", "title", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "formatTime", "date", "Ljava/util/Date;", "formatTimeRemaining", "targetTime", "isPrayerTimeActive", "prayerTime", "app_debug"})
public final class PrayerTimesScreensKt {
    
    @androidx.compose.runtime.Composable
    public static final void PrayerTimesScreen(@org.jetbrains.annotations.Nullable
    com.prayertimes.app.PrayerTimesManager prayerTimesManager, @org.jetbrains.annotations.Nullable
    com.prayertimes.app.SettingsManager settingsManager) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void NextPrayerCard(@org.jetbrains.annotations.NotNull
    com.prayertimes.app.PrayerTime prayer) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void CurrentPrayerCard(@org.jetbrains.annotations.NotNull
    com.prayertimes.app.PrayerTime prayer) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PrayerTimeItem(@org.jetbrains.annotations.NotNull
    com.prayertimes.app.PrayerTime prayer) {
    }
    
    private static final java.lang.String formatTime(java.util.Date date) {
        return null;
    }
    
    private static final java.lang.String formatTimeRemaining(java.util.Date targetTime) {
        return null;
    }
    
    private static final boolean isPrayerTimeActive(com.prayertimes.app.PrayerTime prayerTime) {
        return false;
    }
    
    @androidx.compose.runtime.Composable
    public static final void LocationStatusCard(@org.jetbrains.annotations.NotNull
    java.lang.String status) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void SettingsScreen(@org.jetbrains.annotations.Nullable
    com.prayertimes.app.PrayerTimesManager prayerTimesManager, @org.jetbrains.annotations.Nullable
    com.prayertimes.app.SettingsManager settingsManager, @org.jetbrains.annotations.Nullable
    androidx.navigation.NavController navController, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onDarkModeChanged) {
    }
    
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void AdvancedSettingsScreen(@org.jetbrains.annotations.Nullable
    com.prayertimes.app.PrayerTimesManager prayerTimesManager, @org.jetbrains.annotations.Nullable
    com.prayertimes.app.SettingsManager settingsManager, @org.jetbrains.annotations.Nullable
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void SettingsSection(java.lang.String title, kotlin.jvm.functions.Function0<kotlin.Unit> content) {
    }
}