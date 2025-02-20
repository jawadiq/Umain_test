package com.example.umain_test.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilterId(
    @SerialName("id")
    val id: List<String>,
    @SerialName("name")
    val name: String,
    @SerialName("image_url")
    val imageUrl: String

)