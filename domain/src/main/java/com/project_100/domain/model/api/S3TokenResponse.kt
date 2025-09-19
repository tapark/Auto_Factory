package com.teddy_park.domain.model.api

data class S3TokenResponse(
    val accessKeyId: String = "",
    val secretKey: String = "",
    val identityId: String? = null,
    val sessionToken: String? = null,
    val expiration: String? = null,
)