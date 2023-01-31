package com.sanathcoding.parkingspotfinderapp.presentation

import com.google.android.gms.maps.model.LatLng
import com.sanathcoding.parkingspotfinderapp.model.ParkingSpot

sealed interface MapEvent {
    object toggleFallOutMap: MapEvent
    data class OnMapLongClick(val latLng: LatLng): MapEvent
    data class OnInfoWindowClick(val spot: ParkingSpot): MapEvent
}
