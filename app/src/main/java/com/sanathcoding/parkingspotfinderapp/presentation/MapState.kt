package com.sanathcoding.parkingspotfinderapp.presentation

import com.google.android.gms.maps.model.MapStyleOptions
import com.google.maps.android.compose.MapProperties

data class MapState(
    val properties: MapProperties = MapProperties(),
    val isFallOutMap: Boolean = false
)
