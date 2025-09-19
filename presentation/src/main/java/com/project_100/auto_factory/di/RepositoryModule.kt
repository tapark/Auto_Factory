package com.project_100.auto_factory.di

import com.teddy_park.domain.repository.ApiRepository
import com.teddy_park.data.repository.ApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.teddy_park.data.datasource.ApiDataSource
import com.teddy_park.data.datasource.RoomDataSource
import com.teddy_park.data.datasource.NumberDataSource
import com.teddy_park.data.repository.RoomRepositoryImpl
import com.teddy_park.data.repository.NumberRepositoryImpl
import com.teddy_park.domain.repository.RoomRepository
import com.teddy_park.domain.repository.NumberRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideApiRepository(apiDataSource: ApiDataSource): ApiRepository {
        return ApiRepositoryImpl(apiDataSource)
    }


    @Provides
    @Singleton
    fun provideRoomRepository(roomDataSource: RoomDataSource) : RoomRepository {
        return RoomRepositoryImpl(roomDataSource)
    }

    @Provides
    @Singleton
    fun provideUserInfoRepository(numberDataSource: NumberDataSource) : NumberRepository {
        return NumberRepositoryImpl(numberDataSource)
    }

}