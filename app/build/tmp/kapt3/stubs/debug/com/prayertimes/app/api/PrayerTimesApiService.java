package com.prayertimes.app.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jk\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\t2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJk\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u00122\b\b\u0003\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\t2\b\b\u0003\u0010\u000b\u001a\u00020\t2\b\b\u0003\u0010\f\u001a\u00020\t2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/prayertimes/app/api/PrayerTimesApiService;", "", "getPrayerTimes", "Lretrofit2/Response;", "Lcom/prayertimes/app/api/PrayerTimesResponse;", "latitude", "", "longitude", "method", "", "school", "latitudeAdjustmentMethod", "adjustment", "month", "year", "(DDIIIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrayerTimesByCity", "city", "", "country", "(Ljava/lang/String;Ljava/lang/String;IIIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface PrayerTimesApiService {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "v1/timings")
    public abstract java.lang.Object getPrayerTimes(@retrofit2.http.Query(value = "latitude")
    double latitude, @retrofit2.http.Query(value = "longitude")
    double longitude, @retrofit2.http.Query(value = "method")
    int method, @retrofit2.http.Query(value = "school")
    int school, @retrofit2.http.Query(value = "latitudeAdjustmentMethod")
    int latitudeAdjustmentMethod, @retrofit2.http.Query(value = "adjustment")
    int adjustment, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Query(value = "month")
    java.lang.Integer month, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Query(value = "year")
    java.lang.Integer year, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.prayertimes.app.api.PrayerTimesResponse>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "v1/timingsByCity")
    public abstract java.lang.Object getPrayerTimesByCity(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "city")
    java.lang.String city, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "country")
    java.lang.String country, @retrofit2.http.Query(value = "method")
    int method, @retrofit2.http.Query(value = "school")
    int school, @retrofit2.http.Query(value = "latitudeAdjustmentMethod")
    int latitudeAdjustmentMethod, @retrofit2.http.Query(value = "adjustment")
    int adjustment, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Query(value = "month")
    java.lang.Integer month, @org.jetbrains.annotations.Nullable
    @retrofit2.http.Query(value = "year")
    java.lang.Integer year, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.prayertimes.app.api.PrayerTimesResponse>> continuation);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
    }
}