package com.example.wetherapp.ui

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wetherapp.ui.Components.ExpandableSection
import com.example.wetherapp.ui.Model.ForecastFact
import com.example.wetherapp.ui.Model.WeatherFact
import dev.chrisbanes.haze.HazeState

@Composable
fun Home(weatherFacts: List<WeatherFact>, facts: List<WeatherFact>,modifier: Modifier=Modifier,hazeState:HazeState) {
    //val hazeState = remember { HazeState() }
    LazyColumn(
        modifier = Modifier.padding(top = 16.dp)
            //.background(Color.Transparent)
    )
    {
        item {
            Column(
                modifier = Modifier.padding(10.dp)

            ) {
                DetailsView(title = "Details",facts = facts, modifier = modifier)
                ListDivider()
                Forecast5DaysView(facts = weatherFacts, modifier = modifier)
            }
        }
    }
}

@Composable
fun WeatherHeader(currentTempC: Double = 23.0, currentConditions: String = "Облачно",modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxWidth()
    ) {

        Column(modifier = modifier.padding(horizontal = 24.dp, vertical = 16.dp))
        {
            Row(
                modifier = modifier.align(Alignment.CenterHorizontally)
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
            Spacer(modifier = modifier.height(2.dp))
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
private fun DetailsView(title: String="Details", modifier: Modifier = Modifier, facts: List<Any>) {
    var factsLocal by remember { mutableStateOf(facts) }
    ExpandableSection(modifier = modifier, title = title) {
        Column {
            val countInRow = 2
            var mas = factsLocal as List<WeatherFact>
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
}
}

@Composable
private fun Forecast5DaysView(title: String="Forecast for 5 days", modifier: Modifier = Modifier, facts: List<Any>) {
    var factsLocal by remember { mutableStateOf(facts) }
    ExpandableSection(modifier = modifier, title = title) {
        Column {

            facts.forEach { fact->
                ForecastFact(fact as WeatherFact)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun weatherHeaderPreview() {
    WeatherHeader(2.0, "Облачно")
}