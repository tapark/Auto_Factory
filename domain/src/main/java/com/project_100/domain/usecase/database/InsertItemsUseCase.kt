package com.teddy_park.domain.usecase.database

import com.teddy_park.domain.model.database.FortuneEntity
import com.teddy_park.domain.repository.RoomRepository
import javax.inject.Inject

class InsertItemsUseCase @Inject constructor(
    private val repository: RoomRepository
) {

    fun execute(items: List<FortuneEntity>) {
        repository.insertItems(items)
    }
}