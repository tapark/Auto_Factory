package com.teddy_park.data.repository

import com.teddy_park.data.datasource.RoomDataSource
import com.teddy_park.domain.model.database.FortuneEntity
import com.teddy_park.domain.repository.RoomRepository
import javax.inject.Inject

/**
 * Domain Layer 의 Repository Interface
 */
class RoomRepositoryImpl @Inject constructor(
    private val roomDataSource: RoomDataSource
) : RoomRepository {
    override fun insertData(data: FortuneEntity): Long
    = roomDataSource.insertData(data)

    override fun insertItems(items: List<FortuneEntity>)
    = roomDataSource.insertItems(items)

    override fun getAllData(): List<FortuneEntity>
    = roomDataSource.getAllData()

    override fun deleteData(data: FortuneEntity)
    = roomDataSource.deleteData(data)

    override fun deleteAllData(): Int
    = roomDataSource.deleteAllData()


}