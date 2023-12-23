package com.example.wetherapp.ui.Model

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
fun ForecastFact(weather: WeatherFact,modifier: Modifier=Modifier){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp).fillMaxWidth()){
        AsyncImage(
            model = weather.iconURL,
            contentDescription = null
        )
        Text(weather.day)
        Spacer(modifier.padding(horizontal = 8.dp))
        Text(weather.label)
        Spacer(modifier.padding(horizontal = 8.dp))
        Text(weather.value/*, modifier=Modifier.align(Arrangement.End)*/)
    }
}

fun Weather.get5DaysForecast()= listOf<WeatherFact>(
    WeatherFact(day = "Today",
        label = this.forecast.forecastday[0].day.condition.text,
        value = "${this.forecast.forecastday[0].day.maxtempC} /" +
                "${this.forecast.forecastday[0].day.mintempC}",
        iconURL = this.forecast.forecastday[0].day.condition.icon
        ),
    WeatherFact(day = "Tomorrow",
        label = this.forecast.forecastday[0].day.condition.text,
        value = "${this.forecast.forecastday[0].day.maxtempC} /" +
                "${this.forecast.forecastday[0].day.mintempC}",
        iconURL = this.forecast.forecastday[0].day.condition.icon
    ),
    WeatherFact(day = "Today",
        label = this.forecast.forecastday[0].day.condition.text,
        value = "${this.forecast.forecastday[0].day.maxtempC} /" +
                "${this.forecast.forecastday[0].day.mintempC}",
        iconURL = this.forecast.forecastday[0].day.condition.icon
    ),
    WeatherFact(day = "Today",
        label = this.forecast.forecastday[0].day.condition.text,
        value = "${this.forecast.forecastday[0].day.maxtempC} /" +
                "${this.forecast.forecastday[0].day.mintempC}",
        iconURL = this.forecast.forecastday[0].day.condition.icon
    ),
    WeatherFact(day = "Today",
        label = this.forecast.forecastday[0].day.condition.text,
        value = "${this.forecast.forecastday[0].day.maxtempC} /" +
                "${this.forecast.forecastday[0].day.mintempC}",
        iconURL = this.forecast.forecastday[0].day.condition.icon
    ),
)
@Composable
@Preview(showBackground = true)
fun ForecastFactPreview(){
    ForecastFact(weather=WeatherFact(),modifier=Modifier)
}