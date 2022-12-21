package com.example.week9_standardmission

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherDto(
    @SerializedName("main")
    var main: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("icon")
    var icon: String?,
) : Serializable {
}
