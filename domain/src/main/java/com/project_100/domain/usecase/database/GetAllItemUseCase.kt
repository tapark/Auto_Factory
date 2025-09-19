package com.teddy_park.domain.usecase.database

import com.teddy_park.domain.model.database.FortuneEntity
import com.teddy_park.domain.repository.RoomRepository
import javax.inject.Inject

class GetAllItemUseCase @Inject constructor(
    private val repository: RoomRepository
) {

    fun execute(): List<FortuneEntity> {
        return repository.getAllData()
    }
}