package com.teddy_park.domain.usecase.aws_s3

import androidx.annotation.WorkerThread
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import com.teddy_park.domain.repository.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import okhttp3.Response

import javax.inject.Inject

class GetS3TokenUseCase @Inject constructor(
    private val apiRepository: ApiRepository
) {

    @WorkerThread
    fun invoke(
        onComplete: () -> Unit,
        onError: (Response) -> Unit,
        onException: (String) -> Unit
    ) = flow {
        val response = apiRepository.getS3Token()
        response.suspendOnSuccess {
            emit(data)
        }.suspendOnError {
            onError(raw)
        }.suspendOnException {
            onException("$exception $message")
        }
    }.onCompletion { onComplete() }.flowOn(Dispatchers.IO)

}