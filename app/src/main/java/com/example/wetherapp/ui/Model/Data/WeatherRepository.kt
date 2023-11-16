package com.example.wetherapp.ui.Model.Data

import com.example.wetherapp.ui.Model.Weather
import com.example.wetherapp.ui.Retrofit.Interface.WeatherServices

interface WeatherRepository {
    suspend fun getForecast(city: String, days: Int): Weather
}

class NetworkWeatherRepository(
    private val weatherService: WeatherServices
) : WeatherRepository {
    override suspend fun getForecast(
        city: String,
        days: Int
    ): Weather = weatherService.getForecast(city, days).apply {
        Weather(
            location = this.location,
            /*current = this.current,
            forecast = this.forecast*/
        )
    }

}
