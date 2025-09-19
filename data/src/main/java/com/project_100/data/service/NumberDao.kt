package com.teddy_park.data.service

import androidx.room.*
import com.teddy_park.domain.model.database.FortuneEntity
import com.teddy_park.domain.model.database.NumberEntity

/**
 * Data Access Object
 *
 * 필요한 데이터를 DB 에서 가지고 오기 위한 쿼리를 작성.
 */
@Dao
interface NumberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNumber(data: NumberEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(items: List<NumberEntity>)

    @Query("SELECT * FROM number_table")
    fun getAllNumber(): List<NumberEntity>

    @Delete
    fun deleteNumber(data: NumberEntity)

    @Query("DELETE FROM data_table")
    fun deleteAllNumber() : Int

}