package com.sanathcoding.parkingspotfinderapp.di

import android.app.Application
import androidx.room.Room
import com.sanathcoding.parkingspotfinderapp.data.local.ParkingSpotDao
import com.sanathcoding.parkingspotfinderapp.data.local.ParkingSpotDataBase
import com.sanathcoding.parkingspotfinderapp.data.local.repository.ParkingSpotRepositoryImpl
import com.sanathcoding.parkingspotfinderapp.model.repository.ParkingSpotRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideParkingSpotDatabase(app: Application): ParkingSpotDataBase {
        return Room.databaseBuilder(
            app,
            ParkingSpotDataBase::class.java,
            "parking_spot.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideParkingSpotRepository(db: ParkingSpotDataBase): ParkingSpotRepository {
        return ParkingSpotRepositoryImpl(db.dao)
    }

}