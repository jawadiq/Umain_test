package com.example.umain_test.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Restaurants(
    @SerialName("restaurants")
    val restaurants: List<Restaurant>
)