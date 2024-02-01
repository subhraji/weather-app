package com.example.weatherapplication.model

data class FutureData(
    val day: String,
    val picPath: String,
    val status: String,
    val highTemp: Int,
    val lowTemp: Int
)
