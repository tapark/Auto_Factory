package com.teddy_park.data.datasource

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.teddy_park.data.service.DataDao
import com.teddy_park.domain.model.database.FortuneEntity

/**
 * DataSource 에서 선언한 Interface 의 구현부.
 * 해당 Interface 를 상속받아 사용한다.
 * Local DB 를 사용하기 때문에 MovieDao 를 사용하여 데이터를 가져온다.
 *
 * @param movieDao Local movie Data 가 저장 되어있는 DB
 */
class RoomDataSource(private val dataDao: DataDao) {

    fun insertData(data: FortuneEntity): Long
    = dataDao.insertData(data)

    fun insertItems(items: List<FortuneEntity>)
    = dataDao.insertItems(items)

    fun getAllData(): List<FortuneEntity>
    = dataDao.getAllData()

    fun deleteData(data: FortuneEntity)
    = dataDao.deleteData(data)

    fun deleteAllData() : Int
    = dataDao.deleteAllData()

}