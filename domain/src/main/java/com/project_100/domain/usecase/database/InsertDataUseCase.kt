package com.teddy_park.domain.usecase.database

import com.teddy_park.domain.model.database.FortuneEntity
import com.teddy_park.domain.repository.RoomRepository
import javax.inject.Inject

class InsertDataUseCase @Inject constructor(
    private val repository: RoomRepository
) {

    fun execute(data: FortuneEntity): Long {
        return repository.insertData(data)
    }
}