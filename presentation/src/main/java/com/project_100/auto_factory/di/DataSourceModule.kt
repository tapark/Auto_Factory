package com.project_100.auto_factory.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.teddy_park.data.datasource.ApiDataSource
import com.teddy_park.data.datasource.RoomDataSource
import com.teddy_park.data.datasource.NumberDataSource
import com.teddy_park.data.service.ApiService
import com.teddy_park.data.service.DataDao
import com.teddy_park.data.service.NumberDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideApiDataSource(apiService: ApiService): ApiDataSource {
        return ApiDataSource(apiService)
    }

    @Provides
    @Singleton
    fun provideRoomDataSource(dataDao: DataDao) : RoomDataSource {
        return RoomDataSource(dataDao)
    }

    @Provides
    @Singleton
    fun provideUserInfoDataSource(numberDao: NumberDao) : NumberDataSource {
        return NumberDataSource(numberDao)
    }

}