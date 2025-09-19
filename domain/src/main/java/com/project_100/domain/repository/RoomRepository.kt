package com.teddy_park.domain.repository

import com.teddy_park.domain.model.database.FortuneEntity

/**
 * UseCase 에 필요한 Interface 를 선한한 Repository.
 * RepositoryImpl 에서 구현되며, 실제 필요한 데이터를 가져온다.
 */
interface RoomRepository {
    fun insertData(data: FortuneEntity): Long

    fun insertItems(items: List<FortuneEntity>)

    fun getAllData(): List<FortuneEntity>

    fun deleteData(data: FortuneEntity)

    fun deleteAllData() : Int
}