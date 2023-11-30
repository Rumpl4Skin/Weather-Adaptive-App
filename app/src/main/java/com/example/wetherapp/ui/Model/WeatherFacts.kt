package com.example.wetherapp.ui.Model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Air
import androidx.compose.material.icons.outlined.BedtimeOff
import androidx.compose.material.icons.outlined.Brightness5
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material.icons.outlined.DarkMode
import androidx.compose.material.icons.outlined.DeviceThermostat
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material.icons.outlined.Speed
import androidx.compose.material.icons.outlined.Umbrella
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.WbTwilight
import androidx.compose.ui.graphics.vector.ImageVector

data class WeatherFact(
    val label: String="Tempeture",
    val value: String="9|-10",
    val icon: ImageVector=Icons.Outlined.DeviceThermostat,
)

fun Weather.getFacts()= listOf(
    WeatherFact(
        label = "Temperature",
        value = "${forecast.forecastday[0].day.maxtempC}°   |  ${forecast.forecastday[0].day.mintempC}°",
        icon = Icons.Outlined.DeviceThermostat
    ),
    WeatherFact(
        label = "Feels like",
        value = "${current.feelslikeC}°",
        icon = Icons.Outlined.Face
    ),
    WeatherFact(
        label = "Wind speed",
        value = "${current.windKph} km/h",
        icon = Icons.Outlined.Air
    ),
    WeatherFact(
        label = "Precipitation",
        value = "${current.precipMm} mm",
        icon = Icons.Outlined.Umbrella
    ),
    WeatherFact(
        label = "Cloud cover",
        value = "${current.cloud}%",
        icon = Icons.Outlined.Cloud
    ),

    WeatherFact(
        label = "Pressure",
        value = "${current.pressureMb} bar",
        icon = Icons.Outlined.Speed
    ),
    WeatherFact(
        label = "UV Index",
        value = "${current.uv}",
        icon = Icons.Outlined.Brightness5
    ),
    WeatherFact(
        label = "Visibility",
        value = "${current.visKm} km",
        icon = Icons.Outlined.Visibility
    ),
    WeatherFact(
        label = "Sunrise",
        value = forecast.forecastday[0].astro.sunrise,
        icon = Icons.Outlined.LightMode
    ),
    WeatherFact(
        label = "Sunset",
        value = forecast.forecastday[0].astro.sunrise,
        icon = Icons.Outlined.WbTwilight
    ),
    WeatherFact(
        label = "Moonrise",
        value = forecast.forecastday[0].astro.moonrise,
        icon = Icons.Outlined.DarkMode
    ),
    WeatherFact(
        label = "Moonset",
        value = forecast.forecastday[0].astro.moonset,
        icon = Icons.Outlined.BedtimeOff
    ),
)