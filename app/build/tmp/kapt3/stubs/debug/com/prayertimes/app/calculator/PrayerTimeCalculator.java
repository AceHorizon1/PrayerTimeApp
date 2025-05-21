package com.prayertimes.app.calculator;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J(\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/prayertimes/app/calculator/PrayerTimeCalculator;", "", "()V", "TAG", "", "calculatePrayerTimes", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator$PrayerTimes;", "location", "Landroid/location/Location;", "date", "Ljava/util/Date;", "method", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator$CalculationMethod;", "asrMethod", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator$AsrMethod;", "calculateSunPosition", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator$SunPosition;", "julianDate", "", "calculateTime", "calendar", "Ljava/util/Calendar;", "angle", "sunPosition", "getJulianDate", "AsrMethod", "CalculationMethod", "PrayerTimes", "SunPosition", "app_debug"})
public final class PrayerTimeCalculator {
    private final java.lang.String TAG = "PrayerTimeCalculator";
    
    public PrayerTimeCalculator() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.prayertimes.app.calculator.PrayerTimeCalculator.PrayerTimes calculatePrayerTimes(@org.jetbrains.annotations.NotNull
    android.location.Location location, @org.jetbrains.annotations.NotNull
    java.util.Date date, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.PrayerTimeCalculator.CalculationMethod method, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.calculator.PrayerTimeCalculator.AsrMethod asrMethod) {
        return null;
    }
    
    private final double getJulianDate(java.util.Calendar calendar) {
        return 0.0;
    }
    
    private final com.prayertimes.app.calculator.PrayerTimeCalculator.SunPosition calculateSunPosition(double julianDate) {
        return null;
    }
    
    private final java.util.Date calculateTime(java.util.Calendar calendar, android.location.Location location, double angle, com.prayertimes.app.calculator.PrayerTimeCalculator.SunPosition sunPosition) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/prayertimes/app/calculator/PrayerTimeCalculator$CalculationMethod;", "", "fajrAngle", "", "ishaAngle", "(Ljava/lang/String;IDD)V", "getFajrAngle", "()D", "getIshaAngle", "MUSLIM_WORLD_LEAGUE", "ISNA", "EGYPTIAN", "KARACHI", "TEHRAN", "SHIA", "GULF", "KUWAIT", "QATAR", "SINGAPORE", "NORTH_AMERICA", "DUBAI", "MOONSIGHTING", "app_debug"})
    public static enum CalculationMethod {
        /*public static final*/ MUSLIM_WORLD_LEAGUE /* = new MUSLIM_WORLD_LEAGUE(0.0, 0.0) */,
        /*public static final*/ ISNA /* = new ISNA(0.0, 0.0) */,
        /*public static final*/ EGYPTIAN /* = new EGYPTIAN(0.0, 0.0) */,
        /*public static final*/ KARACHI /* = new KARACHI(0.0, 0.0) */,
        /*public static final*/ TEHRAN /* = new TEHRAN(0.0, 0.0) */,
        /*public static final*/ SHIA /* = new SHIA(0.0, 0.0) */,
        /*public static final*/ GULF /* = new GULF(0.0, 0.0) */,
        /*public static final*/ KUWAIT /* = new KUWAIT(0.0, 0.0) */,
        /*public static final*/ QATAR /* = new QATAR(0.0, 0.0) */,
        /*public static final*/ SINGAPORE /* = new SINGAPORE(0.0, 0.0) */,
        /*public static final*/ NORTH_AMERICA /* = new NORTH_AMERICA(0.0, 0.0) */,
        /*public static final*/ DUBAI /* = new DUBAI(0.0, 0.0) */,
        /*public static final*/ MOONSIGHTING /* = new MOONSIGHTING(0.0, 0.0) */;
        private final double fajrAngle = 0.0;
        private final double ishaAngle = 0.0;
        
        CalculationMethod(double fajrAngle, double ishaAngle) {
        }
        
        public final double getFajrAngle() {
            return 0.0;
        }
        
        public final double getIshaAngle() {
            return 0.0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/prayertimes/app/calculator/PrayerTimeCalculator$AsrMethod;", "", "(Ljava/lang/String;I)V", "STANDARD", "HANAFI", "app_debug"})
    public static enum AsrMethod {
        /*public static final*/ STANDARD /* = new STANDARD() */,
        /*public static final*/ HANAFI /* = new HANAFI() */;
        
        AsrMethod() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/prayertimes/app/calculator/PrayerTimeCalculator$PrayerTimes;", "", "fajr", "Ljava/util/Date;", "sunrise", "dhuhr", "asr", "maghrib", "isha", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;)V", "getAsr", "()Ljava/util/Date;", "getDhuhr", "getFajr", "getIsha", "getMaghrib", "getSunrise", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
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
        public final com.prayertimes.app.calculator.PrayerTimeCalculator.PrayerTimes copy(@org.jetbrains.annotations.NotNull
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
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/prayertimes/app/calculator/PrayerTimeCalculator$SunPosition;", "", "declination", "", "equationOfTime", "(DD)V", "getDeclination", "()D", "getEquationOfTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    static final class SunPosition {
        private final double declination = 0.0;
        private final double equationOfTime = 0.0;
        
        @org.jetbrains.annotations.NotNull
        public final com.prayertimes.app.calculator.PrayerTimeCalculator.SunPosition copy(double declination, double equationOfTime) {
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
        
        public SunPosition(double declination, double equationOfTime) {
            super();
        }
        
        public final double component1() {
            return 0.0;
        }
        
        public final double getDeclination() {
            return 0.0;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        public final double getEquationOfTime() {
            return 0.0;
        }
    }
}