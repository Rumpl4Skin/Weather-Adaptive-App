package com.example.wetherapp.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wetherapp.ui.Model.Weather
import com.example.wetherapp.ui.Retrofit.AppContainer
import com.example.wetherapp.ui.Retrofit.DefaultAppContainer
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _currentCity = mutableStateOf("Minsk")
    private val _days = mutableIntStateOf(3)
    private val _weather = mutableStateOf(Weather())

    val currentCity: State<String> = _currentCity
    val days: State<Int> = _days
    val weather: State<Weather> = _weather
    lateinit var container: AppContainer



    init {
        getWeather(currentCity.value, days.value)
    }


    fun getWeather(city: String, days: Int) {
        viewModelScope.launch {
            container = DefaultAppContainer()
            val response = container.weatherRepository.getForecast(city, days)
            _weather.value = response
        }
    }
}