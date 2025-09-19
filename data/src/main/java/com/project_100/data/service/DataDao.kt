package com.teddy_park.data.service

import androidx.room.*
import com.teddy_park.domain.model.database.FortuneEntity

/**
 * Data Access Object
 *
 * 필요한 데이터를 DB 에서 가지고 오기 위한 쿼리를 작성.
 */
@Dao
interface DataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertData(data: FortuneEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(items: List<FortuneEntity>)

    @Query("SELECT * FROM data_table")
    fun getAllData(): List<FortuneEntity>

    @Delete
    fun deleteData(data: FortuneEntity)

    @Query("DELETE FROM data_table")
    fun deleteAllData() : Int
}