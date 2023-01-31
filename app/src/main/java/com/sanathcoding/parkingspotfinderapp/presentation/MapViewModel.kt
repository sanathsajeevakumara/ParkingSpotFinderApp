package com.sanathcoding.parkingspotfinderapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.MapStyleOptions
import com.sanathcoding.parkingspotfinderapp.model.ParkingSpot
import com.sanathcoding.parkingspotfinderapp.model.repository.ParkingSpotRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    private val repository: ParkingSpotRepository
) : ViewModel() {
    var mapState by mutableStateOf(MapState())

    init {
        viewModelScope.launch {
            repository.getParkingSpots().collectLatest { spots ->
                mapState = mapState.copy(
                    parkingSpots = spots
                )
            }
        }
    }

    fun onEvent(event: MapEvent) {
        when (event) {
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
            is MapEvent.OnMapLongClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.insertParkingSpot(
                        ParkingSpot(
                            event.latLng.latitude,
                            event.latLng.longitude
                        )
                    )
                }
            }
            is MapEvent.OnInfoWindowClick -> {
                viewModelScope.launch(Dispatchers.IO) {
                    repository.deleteParkingSpot(event.spot)
                }
            }
        }
    }
}