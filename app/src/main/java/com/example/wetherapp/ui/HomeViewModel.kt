package com.example.wetherapp.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wetherapp.ui.Model.Weather
import com.example.wetherapp.ui.Model.WeatherFact
import com.example.wetherapp.ui.Model.getFacts
import com.example.wetherapp.ui.Retrofit.AppContainer
import com.example.wetherapp.ui.Retrofit.DefaultAppContainer
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _currentCity = mutableStateOf("Minsk")
    private val _days = mutableIntStateOf(3)
    private val _weather = mutableStateOf(Weather())
    private val _weatherFacts = mutableStateListOf<WeatherFact>()
    private val _isExpanded = mutableStateOf(false)

    val currentCity: State<String> = _currentCity
    val days: State<Int> = _days
    val weather: State<Weather> = _weather
    val isExpanded: State<Boolean> = _isExpanded
    val weatherFacts: SnapshotStateList<WeatherFact> = _weatherFacts
    lateinit var container: AppContainer



    init {
        getWeather(currentCity.value, days.value)
    }


    fun getWeather(city: String, days: Int) {
        viewModelScope.launch {
            container = DefaultAppContainer()
            _weather.value = container.weatherRepository.getForecast(city, days)
            joinAll()
            _weatherFacts.addAll(_weather.value.getFacts())
        }
    }

    fun changeExpanded(){
        _isExpanded.value=!_isExpanded.value
    }
}