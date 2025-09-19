package com.teddy_park.data.service

import com.skydoves.sandwich.ApiResponse
import com.teddy_park.domain.model.api.PostObjectRequest
import com.teddy_park.domain.model.api.PostObjectResponse
import com.teddy_park.domain.model.api.S3TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("api/aws")
    suspend fun getS3Token(

    ): ApiResponse<S3TokenResponse>

    @POST("api/posts/{postTypCd}")
    suspend fun postObject(
        @Path("postTypCd", encoded = true) postTypCd: String,
        @Body body: PostObjectRequest
    ): ApiResponse<PostObjectResponse>

//    @PUT("user/seller/file-manager/folder")
//    suspend fun renameFolder(
//        @Body body: RenameFolderRequest
//    ): ApiResponse<RenameFolderResponse>
//
//    @POST("user/seller/file-manager/folder")
//    suspend fun createFolder(
//        @Body body: CreateFolderRequest
//    ): ApiResponse<CreateFolderResponse>
//
//    @DELETE("user/seller/file-manager/folder")
//    suspend fun deleteFolder(
//        @Query("folderNo", encoded = true) folderNo: String
//    ): ApiResponse<DeleteFolderResponse>


}