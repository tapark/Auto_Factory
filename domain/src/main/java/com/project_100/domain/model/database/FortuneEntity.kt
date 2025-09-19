package com.teddy_park.domain.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data_table")
data class FortuneEntity(
    @PrimaryKey(autoGenerate = false)
    val index: String,
    val message: String,
)