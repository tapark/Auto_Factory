package com.teddy_park.domain.model.api

data class PostObjectRequest(
    val amount: Int = 0,
    val placeHopeTrnscCd: String = "string",
    val placeTrnscCd: String = "string",
    val productTypCd: String = "string",
    val sellerId: String = "string",
    val title: String = "string"
)
