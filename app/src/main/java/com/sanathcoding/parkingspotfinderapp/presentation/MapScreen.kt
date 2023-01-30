package com.sanathcoding.parkingspotfinderapp.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material.icons.filled.ToggleOn
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

@Composable
fun MapScreen(
    viewModel: MapViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val mapUiSetting = remember {
        MapUiSettings(zoomControlsEnabled = false)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                viewModel.onEvent(MapEvent.toggleFallOutMap)
            }) {
                Icon(
                    imageVector = if (viewModel.mapState.isFallOutMap) {
                        Icons.Default.ToggleOff
                    } else Icons.Default.ToggleOn, contentDescription = "Toggle Fallout map "
                )
            }
        }
    ) {
        GoogleMap(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            properties = viewModel.mapState.properties,
            uiSettings = mapUiSetting,
            onMapLongClick = {

            }
        )
    }
}