package com.example.week9_standardmission

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("weather")
    var weather: List<WeatherDto> = arrayListOf()
)