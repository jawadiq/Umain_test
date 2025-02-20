package com.example.umain_test.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Restaurant(
    @SerialName("delivery_time_minutes")
    val deliveryTimeMinutes: Int,
    @SerialName("filterIds")
    val filterIds: List<String>,
    @SerialName("id")
    val id: String,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("name")
    val name: String,
    @SerialName("rating")
    val rating: Double
)