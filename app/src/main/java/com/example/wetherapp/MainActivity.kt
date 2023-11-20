package com.example.wetherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.wetherapp.ui.Components.AppBar
import com.example.wetherapp.ui.Home
import com.example.wetherapp.ui.HomeViewModel
import com.example.wetherapp.ui.theme.WetherAppTheme
import com.example.wetherapp.ui.weatherHeader
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

class MainActivity : ComponentActivity() {
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            WetherAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    SwipeRefreshCompose()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun SwipeRefreshCompose() {

        var refreshing by remember { mutableStateOf(false) }
        val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed)
        LaunchedEffect(refreshing) {
            if (refreshing) {
                homeViewModel.getWeather(homeViewModel.currentCity.value, homeViewModel.days.value)
                refreshing = false
            }
        }

        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = refreshing),
            onRefresh = { refreshing = true },
            modifier = Modifier.fillMaxSize()
                .background(brush = Brush.linearGradient(listOf(Color.LightGray, Color.Blue))),
        ) {
            BackdropScaffold(
                scaffoldState = scaffoldState,
                frontLayerBackgroundColor = Color.Transparent.copy(),
                frontLayerScrimColor = Color.Transparent,
                backLayerBackgroundColor = Color.Transparent,
                frontLayerElevation =  (-3).dp,
                appBar = { /*AppBar(homeViewModel.currentCity.value)*/ },
                backLayerContent = {
                    AppBar(homeViewModel.currentCity.value)

                    homeViewModel.weather.value.current?.condition?.text?.let {
                        homeViewModel.weather.value.current?.tempC?.let { it1 ->
                            weatherHeader(it1, it)
                        }
                    }
                                   },
                frontLayerContent = { Home(homeViewModel.weather.value) },
                persistentAppBar = true,

            )


        }

    }
}
