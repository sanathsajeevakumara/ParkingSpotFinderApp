package com.sanathcoding.parkingspotfinderapp.presentation

import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties
import com.sanathcoding.parkingspotfinderapp.model.ParkingSpot

data class MapState(
    val properties: MapProperties = MapProperties(),
    val parkingSpots: List<ParkingSpot> = emptyList(),
    val isFallOutMap: Boolean = false
)
