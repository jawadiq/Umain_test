package com.example.umain_test.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilterIds(
    @SerialName("id")
    val id: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("name")
    val name: String
)