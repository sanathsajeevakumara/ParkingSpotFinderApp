package com.sanathcoding.parkingspotfinderapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.model.MapStyleOptions

class MapViewModel: ViewModel() {
    var mapState by mutableStateOf(MapState())

    fun onEvent(event: MapEvent) {
        when(event) {
            MapEvent.toggleFallOutMap -> {
                mapState = mapState.copy(
                    properties = mapState.properties.copy(
                        mapStyleOptions = if (mapState.isFallOutMap) {
                            null
                        } else MapStyleOptions(MapStyle.json)
                    ),
                    isFallOutMap = !mapState.isFallOutMap
                )
            }
        }
    }
}