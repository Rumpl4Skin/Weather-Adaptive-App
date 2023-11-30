package com.example.wetherapp.ui.Model

import com.example.example.Current
import com.example.example.Forecast
import com.example.example.Location
import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("location") var location : Location = Location(),
    @SerializedName("current" ) var current  : Current  = Current(),
    @SerializedName("forecast") var forecast : Forecast = Forecast()
)

