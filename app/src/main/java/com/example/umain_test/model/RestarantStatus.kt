package com.example.umain_test.model


import androidx.compose.runtime.MutableState
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RestarantStatus(
    @SerialName("is_currently_open")
    val isCurrentlyOpen: Boolean,
    @SerialName("restaurant_id")
    val restaurantId: String
)