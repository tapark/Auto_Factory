package com.teddy_park.data.repository

import com.teddy_park.data.datasource.NumberDataSource
import com.teddy_park.domain.model.database.NumberEntity
import com.teddy_park.domain.repository.NumberRepository
import javax.inject.Inject

/**
 * Domain Layer 의 Repository Interface
 */
class NumberRepositoryImpl @Inject constructor(
    private val numberDataSource: NumberDataSource
) : NumberRepository {


    override fun insertNumber(number: NumberEntity): Long
    = numberDataSource.insertNumber(number)

    override fun insertItems(items: List<NumberEntity>)
    = numberDataSource.insertItems(items)

    override fun getAllNumber(): List<NumberEntity>
    = numberDataSource.getAllNumber()

    override fun deleteNumber(number: NumberEntity)
    = numberDataSource.deleteNumber(number)

    override fun deleteAllNumber(): Int
    = numberDataSource.deleteAllNumber()


}