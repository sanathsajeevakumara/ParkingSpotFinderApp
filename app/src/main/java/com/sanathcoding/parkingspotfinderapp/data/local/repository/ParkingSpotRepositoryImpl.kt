package com.sanathcoding.parkingspotfinderapp.data.local.repository

import androidx.room.Dao
import com.sanathcoding.parkingspotfinderapp.data.local.ParkingSpotDao
import com.sanathcoding.parkingspotfinderapp.data.local.mapper.toParkingSpot
import com.sanathcoding.parkingspotfinderapp.data.local.mapper.toParkingSpotEntity
import com.sanathcoding.parkingspotfinderapp.model.ParkingSpot
import com.sanathcoding.parkingspotfinderapp.model.repository.ParkingSpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ParkingSpotRepositoryImpl @Inject constructor(
    private val dao: ParkingSpotDao
): ParkingSpotRepository {
    override suspend fun insertParkingSpot(spot: ParkingSpot) {
        return dao.insertParkingSpot(spot.toParkingSpotEntity())
    }

    override suspend fun deleteParkingSpot(spot: ParkingSpot) {
        return dao.deleteParkingSpot(spot.toParkingSpotEntity())
    }

    override fun getParkingSpots(): Flow<List<ParkingSpot>> {
        return dao.getParkingSpots().map { spots ->
            spots.map { it.toParkingSpot() }
        }
    }
}