package com.example.wetherapp.ui.Retrofit.Interface

import com.example.wetherapp.ui.Model.Weather
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WeatherServices {
        @Headers("X-RapidAPI-Key: c087823036msh54261da59150faap1e5f86jsn0bb4218bd247",
            "X-RapidAPI-Host: weatherapi-com.p.rapidapi.com")
        @GET("forecast.json")
        suspend fun getForecast(
                @Query("q") city: String,
                @Query("days") days: Int
        ): Weather

}