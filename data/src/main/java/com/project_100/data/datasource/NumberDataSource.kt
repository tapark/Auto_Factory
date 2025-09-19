package com.teddy_park.data.datasource

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.teddy_park.data.service.NumberDao
import com.teddy_park.domain.model.database.NumberEntity

/**
 * DataSource 에서 선언한 Interface 의 구현부.
 * 해당 Interface 를 상속받아 사용한다.
 * Local DB 를 사용하기 때문에 MovieDao 를 사용하여 데이터를 가져온다.
 *
 * @param movieDao Local movie Data 가 저장 되어있는 DB
 */
class NumberDataSource(private val numberDao: NumberDao) {

    fun insertNumber(number: NumberEntity): Long
    = numberDao.insertNumber(number)

    fun insertItems(items: List<NumberEntity>)
    = numberDao.insertItems(items)

    fun getAllNumber(): List<NumberEntity>
    = numberDao.getAllNumber()

    fun deleteNumber(number: NumberEntity)
    = numberDao.deleteNumber(number)

    fun deleteAllNumber() : Int
    = numberDao.deleteAllNumber()

}