package com.teddy_park.domain.model.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number_table")
data class NumberEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val number: String,
    val message: String,
)