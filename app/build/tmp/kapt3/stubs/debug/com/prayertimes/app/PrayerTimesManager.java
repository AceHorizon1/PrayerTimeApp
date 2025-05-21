package com.prayertimes.app;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\r\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0010J\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\f\u0010&\u001a\u00020\'*\u00020\nH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/prayertimes/app/PrayerTimesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "asrMethod", "Lcom/prayertimes/app/AsrMethod;", "calculationMethod", "Lcom/prayertimes/app/CalculationMethod;", "calculator", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator;", "currentLocation", "Landroid/location/Location;", "highLatitudeAdjustment", "Lcom/prayertimes/app/HighLatitudeAdjustment;", "kaabaLocation", "locationListener", "Landroid/location/LocationListener;", "locationManager", "Landroid/location/LocationManager;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "calculateQiblaDirection", "", "()Ljava/lang/Double;", "requestLocationUpdates", "", "setAsrMethod", "method", "setCalculationMethod", "setHighLatitudeAdjustment", "adjustment", "updatePrayerTimes", "", "Lcom/prayertimes/app/PrayerTime;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toCalculatorMethod", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator$CalculationMethod;", "app_debug"})
public final class PrayerTimesManager {
    private final android.content.Context context = null;
    private final java.lang.String TAG = "PrayerTimesManager";
    private final android.location.LocationManager locationManager = null;
    private android.location.Location currentLocation;
    private com.prayertimes.app.CalculationMethod calculationMethod = com.prayertimes.app.CalculationMethod.MUSLIM_WORLD_LEAGUE;
    private com.prayertimes.app.AsrMethod asrMethod = com.prayertimes.app.AsrMethod.STANDARD;
    private com.prayertimes.app.HighLatitudeAdjustment highLatitudeAdjustment = com.prayertimes.app.HighLatitudeAdjustment.NONE;
    private final com.prayertimes.app.calculator.PrayerTimeCalculator calculator = null;
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private final android.location.Location kaabaLocation = null;
    private final android.location.LocationListener locationListener = null;
    
    public PrayerTimesManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    private final void requestLocationUpdates() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updatePrayerTimes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.prayertimes.app.PrayerTime>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Double calculateQiblaDirection() {
        return null;
    }
    
    public final void setCalculationMethod(@org.jetbrains.annotations.NotNull
    com.prayertimes.app.CalculationMethod method) {
    }
    
    public final void setAsrMethod(@org.jetbrains.annotations.NotNull
    com.prayertimes.app.AsrMethod method) {
    }
    
    public final void setHighLatitudeAdjustment(@org.jetbrains.annotations.NotNull
    com.prayertimes.app.HighLatitudeAdjustment adjustment) {
    }
    
    private final com.prayertimes.app.calculator.PrayerTimeCalculator.CalculationMethod toCalculatorMethod(com.prayertimes.app.CalculationMethod $this$toCalculatorMethod) {
        return null;
    }
}