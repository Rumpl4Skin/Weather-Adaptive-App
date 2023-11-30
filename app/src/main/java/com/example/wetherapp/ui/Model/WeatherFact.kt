package com.example.wetherapp.ui.Model

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DeviceThermostat
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WeatherFact(fact:WeatherFact,modifier: Modifier=Modifier){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(8.dp)){
        Icon(imageVector = fact.icon, contentDescription = "Image")

        Spacer(modifier= Modifier.padding(horizontal = 8.dp))
        Column(modifier = Modifier/*.fillMaxWidth()*/){
            Text(fact.label,
                style = androidx.compose.material.MaterialTheme.typography.subtitle1)
            Text(fact.value,
                style = androidx.compose.material.MaterialTheme.typography.caption)

        }
    }
}


@Preview(showBackground = true)
@Composable
fun WeatherFactPreview(){
    WeatherFact(WeatherFact(label = "Temperature",
        value="9|-1",
        icon = Icons.Outlined.DeviceThermostat) )
}