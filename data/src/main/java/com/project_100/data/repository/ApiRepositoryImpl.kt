package com.teddy_park.data.repository

import com.skydoves.sandwich.ApiResponse
import com.teddy_park.domain.model.api.PostObjectRequest
import com.teddy_park.domain.model.api.PostObjectResponse
import com.teddy_park.domain.model.api.S3TokenResponse
import com.teddy_park.domain.repository.ApiRepository
import com.teddy_park.data.datasource.ApiDataSource
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiDataSource: ApiDataSource
): ApiRepository {

    override suspend fun getS3Token(

    ): ApiResponse<S3TokenResponse> {
        return apiDataSource.getS3Token()
    }

    override suspend fun postObject(
        postTypCd: String,
        body: PostObjectRequest
    ): ApiResponse<PostObjectResponse> {
        return apiDataSource.postObject(postTypCd, body)
    }
}