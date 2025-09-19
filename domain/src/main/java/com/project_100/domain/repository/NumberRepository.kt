package com.teddy_park.domain.repository

import com.teddy_park.domain.model.database.NumberEntity

/**
 * UseCase 에 필요한 Interface 를 선한한 Repository.
 * RepositoryImpl 에서 구현되며, 실제 필요한 데이터를 가져온다.
 */
interface NumberRepository {

    fun insertNumber(number: NumberEntity): Long

    fun insertItems(items: List<NumberEntity>)

    fun getAllNumber(): List<NumberEntity>

    fun deleteNumber(number: NumberEntity)

    fun deleteAllNumber() : Int


}