package com.teddy_park.domain.usecase.number

import com.teddy_park.domain.model.database.FortuneEntity
import com.teddy_park.domain.model.database.NumberEntity
import com.teddy_park.domain.repository.NumberRepository
import com.teddy_park.domain.repository.RoomRepository
import javax.inject.Inject

class GetNumberListUseCase @Inject constructor(
    private val repository: NumberRepository
) {

    fun execute(): List<NumberEntity> {
        return repository.getAllNumber()
    }
}