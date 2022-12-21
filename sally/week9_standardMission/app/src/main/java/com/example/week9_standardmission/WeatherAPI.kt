package com.example.week9_standardmission

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("weather?")
    fun getWeather(
        @Query("lat") lat: Int,
        @Query("lon") lon: Int,
        @Query("appid") appid: String,
    ): Call<WeatherResponse>
}