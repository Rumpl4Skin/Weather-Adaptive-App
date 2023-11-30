package com.example.wetherapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ContentAlpha
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wetherapp.ui.Components.ExpandableSection
import com.example.wetherapp.ui.Model.Weather
import com.example.wetherapp.ui.Model.WeatherFact

@Composable
fun Home(weather: Weather, facts: List<WeatherFact>) {
    LazyColumn(
        modifier = Modifier.padding(top = 16.dp)
            .background(Color.Transparent)
    )
    {
        item {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                DetailsView(facts = facts)
            }
        }
    }
}

@Composable
fun WeatherHeader(currentTempC: Int = 23, currentConditions: String = "Облачно") {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp))
        {
            Row(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                androidx.compose.material.Text(
                    text = currentTempC.toString(),
                    style = androidx.compose.material.MaterialTheme.typography.h1.copy(
                        shadow = Shadow(
                            color = Color.DarkGray,
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    color = Color.White
                )
                androidx.compose.material.Text(
                    text = "℃",
                    style = androidx.compose.material.MaterialTheme.typography.h4.copy(
                        shadow = Shadow(
                            color = Color.DarkGray,
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                androidx.compose.material.Text(
                    text = currentConditions,
                    style = androidx.compose.material.MaterialTheme.typography.subtitle1.copy(
                        shadow = Shadow(
                            color = Color.DarkGray,
                            offset = Offset(4f, 4f),
                            blurRadius = 8f
                        )
                    ),
                    color = Color.White,
                )
            }
        }

    }
}

/**
 * Full-width divider with padding
 */
@Composable
fun ListDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 14.dp),
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.08f)
    )
}

@Composable
private fun DetailsView(modifier: Modifier = Modifier, facts: List<WeatherFact>) {
    ExpandableSection(modifier = modifier, title = "Details") {
        Column {
            val countInRow = 2
            var mas = facts
            repeat(mas.size / countInRow) {
                mas.take(countInRow).let {
                    Row {
                        WeatherFact(fact = it[0], modifier=Modifier.weight(1f))
                        Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                        WeatherFact(fact = it[1], modifier=Modifier.weight(1f))
                    }
                }
                mas=mas.drop(countInRow)
            }
        }

        /*repeat(facts.size) {
            Row {
                WeatherFact(fact = facts[i])
                if (i <= facts.size - 3)
                    WeatherFact(fact = facts[i + 1])
            }
            ListDivider()
            i += countInRow
        }
    }*/


}
}

@Composable
fun weatherItem(weather: String) {
    Text(weather)
}

@Preview(showBackground = true)
@Composable
fun weatherHeaderPreview() {
    WeatherHeader(2, "Облачно")
}