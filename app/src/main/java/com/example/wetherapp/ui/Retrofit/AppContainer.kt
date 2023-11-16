package com.example.wetherapp.ui.Retrofit

import com.example.wetherapp.ui.Model.Data.NetworkWeatherRepository
import com.example.wetherapp.ui.Model.Data.WeatherRepository
import com.example.wetherapp.ui.Model.Weather
import com.example.wetherapp.ui.Retrofit.Interface.WeatherServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val weatherRepository: WeatherRepository
}

class DefaultAppContainer : AppContainer {
    private val BASE_URL = "https://weatherapi-com.p.rapidapi.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: WeatherServices by lazy {
        retrofit.create(WeatherServices::class.java)
    }
    override val weatherRepository: WeatherRepository
        get() = NetworkWeatherRepository(retrofitService)
}