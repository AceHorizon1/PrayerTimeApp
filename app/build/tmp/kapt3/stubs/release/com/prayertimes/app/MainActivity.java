package com.prayertimes.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0013H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/prayertimes/app/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "TAG", "", "locationListener", "Landroid/location/LocationListener;", "locationManager", "Landroid/location/LocationManager;", "locationPermissionRequest", "Landroidx/activity/result/ActivityResultLauncher;", "", "prayerTimesManager", "Lcom/prayertimes/app/PrayerTimesManager;", "settingsManager", "Lcom/prayertimes/app/SettingsManager;", "hasLocationPermission", "", "initializePrayerTimesManager", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "requestLocationPermission", "app_release"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.activity.ComponentActivity {
    private final java.lang.String TAG = "MainActivity";
    private com.prayertimes.app.PrayerTimesManager prayerTimesManager;
    private com.prayertimes.app.SettingsManager settingsManager;
    private android.location.LocationManager locationManager;
    private final android.location.LocationListener locationListener = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> locationPermissionRequest = null;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean hasLocationPermission() {
        return false;
    }
    
    private final void requestLocationPermission() {
    }
    
    private final void initializePrayerTimesManager() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
}