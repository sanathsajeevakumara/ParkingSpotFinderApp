package com.sanathcoding.parkingspotfinderapp.model.repository

import com.sanathcoding.parkingspotfinderapp.model.ParkingSpot
import kotlinx.coroutines.flow.Flow

interface ParkingSpotRepository {

    suspend fun insertParkingSpot(spot: ParkingSpot)

    suspend fun deleteParkingSpot(spot: ParkingSpot)

    fun getParkingSpots(): Flow<List<ParkingSpot>>

}