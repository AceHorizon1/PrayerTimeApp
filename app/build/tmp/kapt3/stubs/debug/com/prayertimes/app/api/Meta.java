package com.prayertimes.app.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\bH\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0006H\u00c6\u0003J\u0017\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u00c6\u0003Jg\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\u000eH\u00d6\u0001J\t\u0010)\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013\u00a8\u0006*"}, d2 = {"Lcom/prayertimes/app/api/Meta;", "", "latitude", "", "longitude", "timezone", "", "method", "Lcom/prayertimes/app/api/Method;", "latitudeAdjustmentMethod", "midnightMode", "school", "offset", "", "", "(DDLjava/lang/String;Lcom/prayertimes/app/api/Method;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getLatitude", "()D", "getLatitudeAdjustmentMethod", "()Ljava/lang/String;", "getLongitude", "getMethod", "()Lcom/prayertimes/app/api/Method;", "getMidnightMode", "getOffset", "()Ljava/util/Map;", "getSchool", "getTimezone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class Meta {
    private final double latitude = 0.0;
    private final double longitude = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String timezone = null;
    @org.jetbrains.annotations.NotNull
    private final com.prayertimes.app.api.Method method = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String latitudeAdjustmentMethod = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String midnightMode = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String school = null;
    @org.jetbrains.annotations.Nullable
    private final java.util.Map<java.lang.String, java.lang.Integer> offset = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.prayertimes.app.api.Meta copy(double latitude, double longitude, @org.jetbrains.annotations.NotNull
    java.lang.String timezone, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.api.Method method, @org.jetbrains.annotations.NotNull
    java.lang.String latitudeAdjustmentMethod, @org.jetbrains.annotations.NotNull
    java.lang.String midnightMode, @org.jetbrains.annotations.NotNull
    java.lang.String school, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Integer> offset) {
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
    
    public Meta(double latitude, double longitude, @org.jetbrains.annotations.NotNull
    java.lang.String timezone, @org.jetbrains.annotations.NotNull
    com.prayertimes.app.api.Method method, @org.jetbrains.annotations.NotNull
    java.lang.String latitudeAdjustmentMethod, @org.jetbrains.annotations.NotNull
    java.lang.String midnightMode, @org.jetbrains.annotations.NotNull
    java.lang.String school, @org.jetbrains.annotations.Nullable
    java.util.Map<java.lang.String, java.lang.Integer> offset) {
        super();
    }
    
    public final double component1() {
        return 0.0;
    }
    
    public final double getLatitude() {
        return 0.0;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    public final double getLongitude() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTimezone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.prayertimes.app.api.Method component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.prayertimes.app.api.Method getMethod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLatitudeAdjustmentMethod() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMidnightMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSchool() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, java.lang.Integer> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.Map<java.lang.String, java.lang.Integer> getOffset() {
        return null;
    }
}