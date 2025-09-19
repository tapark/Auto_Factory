package com.teddy_park.data.datasource

import com.skydoves.sandwich.ApiResponse
import com.teddy_park.domain.model.api.PostObjectRequest
import com.teddy_park.domain.model.api.PostObjectResponse
import com.teddy_park.domain.model.api.S3TokenResponse
import com.teddy_park.data.service.ApiService
import javax.inject.Inject

class ApiDataSource @Inject constructor(
    private val apiService: ApiService
) {


    suspend fun getS3Token(

    ): ApiResponse<S3TokenResponse> {
        return apiService.getS3Token()
    }

    suspend fun postObject(
        postTypCd: String,
        body: PostObjectRequest
    ): ApiResponse<PostObjectResponse> {
        return apiService.postObject(postTypCd, body)
    }


}