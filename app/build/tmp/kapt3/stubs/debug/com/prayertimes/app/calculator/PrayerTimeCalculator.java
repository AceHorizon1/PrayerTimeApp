package com.prayertimes.app.calculator;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0004FGHIB\u0005\u00a2\u0006\u0002\u0010\u0002J@\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0002J0\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007H\u0002J,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"JP\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002JL\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\'\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0010\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010.\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0004H\u0002J\u0010\u00100\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J \u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u000203H\u0002J\u0018\u00106\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0018\u00107\u001a\u00020\u001e2\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u001eH\u0002J\u0010\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0002J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J:\u0010=\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020\u0004H\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0007H\u0002J\u0010\u0010C\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u000203H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006J"}, d2 = {"Lcom/prayertimes/app/calculator/PrayerTimeCalculator;", "", "()V", "TAG", "", "adjustTimes", "", "", "times", "timeZone", "lng", "lat", "arccos", "d", "arccot", "x", "arcsin", "arctan", "arctan2", "y", "asrTime", "factor", "time", "jDate", "elv", "calculatePrayerTimes", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator$PrayerTimes;", "location", "Landroid/location/Location;", "date", "Ljava/util/Date;", "method", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator$CalculationMethod;", "asrMethod", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator$AsrMethod;", "computePrayerTimes", "computeTimes", "tz", "cos", "dtr", "fix", "a", "b", "fixAngle", "fixHour", "getDst", "getFormattedTime", "format", "getTimeZone", "julian", "year", "", "month", "day", "midDay", "parseTimeString", "timeStr", "baseDate", "rtd", "r", "sin", "sunAngleTime", "angle", "direction", "sunPosition", "Lcom/prayertimes/app/calculator/PrayerTimeCalculator$SunPosition;", "jd", "tan", "twoDigitsFormat", "num", "AsrMethod", "CalculationMethod", "PrayerTimes", "SunPosition", "app_debug"})
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
    
    private final java.util.Map<java.lang.String, java.lang.String> computeTimes(double jDate, double lat, double lng, double elv, double tz, com.prayertimes.app.calculator.PrayerTimeCalculator.CalculationMethod method, com.prayertimes.app.calculator.PrayerTimeCalculator.AsrMethod asrMethod) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.lang.Double> computePrayerTimes(java.util.Map<java.lang.String, java.lang.Double> times, double jDate, double lat, double elv, com.prayertimes.app.calculator.PrayerTimeCalculator.CalculationMethod method, com.prayertimes.app.calculator.PrayerTimeCalculator.AsrMethod asrMethod) {
        return null;
    }
    
    private final double midDay(double time, double jDate) {
        return 0.0;
    }
    
    private final double sunAngleTime(double angle, double time, double jDate, double lat, double elv, java.lang.String direction) {
        return 0.0;
    }
    
    private final double asrTime(double factor, double time, double jDate, double lat, double elv) {
        return 0.0;
    }
    
    private final com.prayertimes.app.calculator.PrayerTimeCalculator.SunPosition sunPosition(double jd) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, java.lang.Double> adjustTimes(java.util.Map<java.lang.String, java.lang.Double> times, double timeZone, double lng, double lat) {
        return null;
    }
    
    private final java.lang.String getFormattedTime(double time, java.lang.String format) {
        return null;
    }
    
    private final java.util.Date parseTimeString(java.lang.String timeStr, java.util.Date baseDate) {
        return null;
    }
    
    private final double julian(int year, int month, int day) {
        return 0.0;
    }
    
    private final double getTimeZone(java.util.Date date) {
        return 0.0;
    }
    
    private final double getDst(java.util.Date date) {
        return 0.0;
    }
    
    private final double dtr(double d) {
        return 0.0;
    }
    
    private final double rtd(double r) {
        return 0.0;
    }
    
    private final double sin(double d) {
        return 0.0;
    }
    
    private final double cos(double d) {
        return 0.0;
    }
    
    private final double tan(double d) {
        return 0.0;
    }
    
    private final double arcsin(double d) {
        return 0.0;
    }
    
    private final double arccos(double d) {
        return 0.0;
    }
    
    private final double arctan(double d) {
        return 0.0;
    }
    
    private final double arccot(double x) {
        return 0.0;
    }
    
    private final double arctan2(double y, double x) {
        return 0.0;
    }
    
    private final double fixAngle(double a) {
        return 0.0;
    }
    
    private final double fixHour(double a) {
        return 0.0;
    }
    
    private final double fix(double a, double b) {
        return 0.0;
    }
    
    private final java.lang.String twoDigitsFormat(int num) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/prayertimes/app/calculator/PrayerTimeCalculator$CalculationMethod;", "", "displayName", "", "fajrAngle", "", "ishaAngle", "(Ljava/lang/String;ILjava/lang/String;DD)V", "getDisplayName", "()Ljava/lang/String;", "getFajrAngle", "()D", "getIshaAngle", "MWL", "ISNA", "EGYPT", "MAKKAH", "KARACHI", "TEHRAN", "JAFARI", "app_debug"})
    public static enum CalculationMethod {
        /*public static final*/ MWL /* = new MWL(null, 0.0, 0.0) */,
        /*public static final*/ ISNA /* = new ISNA(null, 0.0, 0.0) */,
        /*public static final*/ EGYPT /* = new EGYPT(null, 0.0, 0.0) */,
        /*public static final*/ MAKKAH /* = new MAKKAH(null, 0.0, 0.0) */,
        /*public static final*/ KARACHI /* = new KARACHI(null, 0.0, 0.0) */,
        /*public static final*/ TEHRAN /* = new TEHRAN(null, 0.0, 0.0) */,
        /*public static final*/ JAFARI /* = new JAFARI(null, 0.0, 0.0) */;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String displayName = null;
        private final double fajrAngle = 0.0;
        private final double ishaAngle = 0.0;
        
        CalculationMethod(java.lang.String displayName, double fajrAngle, double ishaAngle) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDisplayName() {
            return null;
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
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/prayertimes/app/calculator/PrayerTimeCalculator$SunPosition;", "", "declination", "", "equation", "(DD)V", "getDeclination", "()D", "getEquation", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    static final class SunPosition {
        private final double declination = 0.0;
        private final double equation = 0.0;
        
        @org.jetbrains.annotations.NotNull
        public final com.prayertimes.app.calculator.PrayerTimeCalculator.SunPosition copy(double declination, double equation) {
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
        
        public SunPosition(double declination, double equation) {
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
        
        public final double getEquation() {
            return 0.0;
        }
    }
}