package com.teddy_park.domain.repository

import com.skydoves.sandwich.ApiResponse
import com.teddy_park.domain.model.api.PostObjectRequest
import com.teddy_park.domain.model.api.PostObjectResponse
import com.teddy_park.domain.model.api.S3TokenResponse

interface ApiRepository {

    suspend fun getS3Token(

    ): ApiResponse<S3TokenResponse>

    suspend fun postObject(
        postTypCd: String,
        body: PostObjectRequest
    ): ApiResponse<PostObjectResponse>

}