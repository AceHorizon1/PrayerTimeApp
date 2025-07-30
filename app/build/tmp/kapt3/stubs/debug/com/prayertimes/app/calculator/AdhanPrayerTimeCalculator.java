package com.prayertimes.app.calculator;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0017\u0018\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJB\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011JB\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0015J8\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u00112\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/prayertimes/app/calculator/AdhanPrayerTimeCalculator;", "", "()V", "TAG", "", "calculatePrayerTimes", "Lcom/prayertimes/app/calculator/AdhanPrayerTimeCalculator$PrayerTimes;", "location", "Landroid/location/Location;", "date", "Ljava/util/Date;", "method", "Lcom/prayertimes/app/calculator/AdhanPrayerTimeCalculator$CalculationMethod;", "asrMethod", "Lcom/prayertimes/app/calculator/AdhanPrayerTimeCalculator$AsrMethod;", "calculatePrayerTimesWithAdjustments", "adjustments", "", "", "getFormattedPrayerTimes", "timeZone", "Ljava/util/TimeZone;", "getSunnahTimes", "AsrMethod", "CalculationMethod", "PrayerTimes", "app_debug"})
public final class AdhanPrayerTimeCalculator {
    private final java.lang.String TAG = "AdhanPrayerTimeCalculator";
    
    public AdhanPrayerTimeCalculator() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.PrayerTimes calculatePrayerTimes(@org.jetbrains.annotations.NotNull
    android.location.Location location, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.CalculationMethod method, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.AsrMethod asrMethod) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.lang.String> getFormattedPrayerTimes(@org.jetbrains.annotations.NotNull
    android.location.Location location, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.CalculationMethod method, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.AsrMethod asrMethod, @org.jetbrains.annotations.NotNull
    java.util.TimeZone timeZone) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.PrayerTimes calculatePrayerTimesWithAdjustments(@org.jetbrains.annotations.NotNull
    android.location.Location location, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.CalculationMethod method, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.AsrMethod asrMethod, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, java.lang.Integer> adjustments) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.util.Date> getSunnahTimes(@org.jetbrains.annotations.NotNull
    android.location.Location location, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.CalculationMethod method, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.AsrMethod asrMethod) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/prayertimes/app/calculator/AdhanPrayerTimeCalculator$CalculationMethod;", "", "displayName", "", "adhanMethod", "error/NonExistentClass", "(Ljava/lang/String;ILjava/lang/String;Lerror/NonExistentClass;)V", "getAdhanMethod", "()Lerror/NonExistentClass;", "Lerror/NonExistentClass;", "getDisplayName", "()Ljava/lang/String;", "MWL", "ISNA", "EGYPT", "MAKKAH", "KARACHI", "DUBAI", "QATAR", "KUWAIT", "MOONSIGHTING", "SINGAPORE", "app_debug"})
    public static enum CalculationMethod {
        /*public static final*/ MWL /* = new MWL(null, null) */,
        /*public static final*/ ISNA /* = new ISNA(null, null) */,
        /*public static final*/ EGYPT /* = new EGYPT(null, null) */,
        /*public static final*/ MAKKAH /* = new MAKKAH(null, null) */,
        /*public static final*/ KARACHI /* = new KARACHI(null, null) */,
        /*public static final*/ DUBAI /* = new DUBAI(null, null) */,
        /*public static final*/ QATAR /* = new QATAR(null, null) */,
        /*public static final*/ KUWAIT /* = new KUWAIT(null, null) */,
        /*public static final*/ MOONSIGHTING /* = new MOONSIGHTING(null, null) */,
        /*public static final*/ SINGAPORE /* = new SINGAPORE(null, null) */;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String displayName = null;
        @org.jetbrains.annotations.NotNull
        private final error.NonExistentClass adhanMethod = null;
        
        CalculationMethod(java.lang.String displayName, error.NonExistentClass adhanMethod) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDisplayName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final error.NonExistentClass getAdhanMethod() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/prayertimes/app/calculator/AdhanPrayerTimeCalculator$AsrMethod;", "", "displayName", "", "adhanMadhab", "error/NonExistentClass", "(Ljava/lang/String;ILjava/lang/String;Lerror/NonExistentClass;)V", "getAdhanMadhab", "()Lerror/NonExistentClass;", "Lerror/NonExistentClass;", "getDisplayName", "()Ljava/lang/String;", "STANDARD", "HANAFI", "app_debug"})
    public static enum AsrMethod {
        /*public static final*/ STANDARD /* = new STANDARD(null, null) */,
        /*public static final*/ HANAFI /* = new HANAFI(null, null) */;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String displayName = null;
        @org.jetbrains.annotations.NotNull
        private final error.NonExistentClass adhanMadhab = null;
        
        AsrMethod(java.lang.String displayName, error.NonExistentClass adhanMadhab) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDisplayName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final error.NonExistentClass getAdhanMadhab() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/prayertimes/app/calculator/AdhanPrayerTimeCalculator$PrayerTimes;", "", "fajr", "Ljava/util/Date;", "sunrise", "dhuhr", "asr", "maghrib", "isha", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;)V", "getAsr", "()Ljava/util/Date;", "getDhuhr", "getFajr", "getIsha", "getMaghrib", "getSunrise", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class PrayerTimes {
        @org.jetbrains.annotations.NotNull
        private final java.util.Date fajr = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.Date sunrise = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.Date dhuhr = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.Date asr = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.Date maghrib = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.Date isha = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.prayertimes.app.calculator.AdhanPrayerTimeCalculator.PrayerTimes copy(@org.jetbrains.annotations.NotNull
        java.util.Date fajr, @org.jetbrains.annotations.NotNull
        java.util.Date sunrise, @org.jetbrains.annotations.NotNull
        java.util.Date dhuhr, @org.jetbrains.annotations.NotNull
        java.util.Date asr, @org.jetbrains.annotations.NotNull
        java.util.Date maghrib, @org.jetbrains.annotations.NotNull
        java.util.Date isha) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        @java.lang.Override
        public java.lang.String toString() {
            return null;
        }
        
        public PrayerTimes(@org.jetbrains.annotations.NotNull
        java.util.Date fajr, @org.jetbrains.annotations.NotNull
        java.util.Date sunrise, @org.jetbrains.annotations.NotNull
        java.util.Date dhuhr, @org.jetbrains.annotations.NotNull
        java.util.Date asr, @org.jetbrains.annotations.NotNull
        java.util.Date maghrib, @org.jetbrains.annotations.NotNull
        java.util.Date isha) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date getFajr() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date getSunrise() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date getDhuhr() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date getAsr() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date getMaghrib() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.Date getIsha() {
            return null;
        }
    }
}