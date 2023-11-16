package com.example.wetherapp.ui.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(city: String) {
    Box(
        modifier = Modifier.padding(6.dp)
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        Column(verticalArrangement = Arrangement.Center,
            modifier = Modifier.matchParentSize()) {
            Text(
                text = "+",
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Justify
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ) {
            Text(
                text = city,
                style = MaterialTheme.typography.h5,
            )

            Text(
                text = "Click to change",
                style = MaterialTheme.typography.overline.copy(
                    textDecoration = TextDecoration.Underline
                ),

                )

        }

    }
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview() {
    AppBar("Minsk")
}