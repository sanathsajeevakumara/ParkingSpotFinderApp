package com.sanathcoding.parkingspotfinderapp.data.local.mapper

import com.sanathcoding.parkingspotfinderapp.data.local.ParkingSpotEntity
import com.sanathcoding.parkingspotfinderapp.model.ParkingSpot

fun ParkingSpotEntity.toParkingSpot(): ParkingSpot {
    return ParkingSpot(
        lat = lat,
        lng = lng,
        id = id
    )
}

fun ParkingSpot.toParkingSpotEntity(): ParkingSpotEntity {
    return ParkingSpotEntity(
        lat = lat,
        lng = lng,
        id = id
    )
}