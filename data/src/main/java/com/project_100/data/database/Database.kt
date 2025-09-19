package com.teddy_park.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.teddy_park.data.service.DataDao
import com.teddy_park.data.service.NumberDao
import com.teddy_park.domain.model.database.FortuneEntity
import com.teddy_park.domain.model.database.NumberEntity

@Database(entities = [FortuneEntity::class, NumberEntity::class], version = 3, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun dataDao(): DataDao
    abstract fun numberDao(): NumberDao
}