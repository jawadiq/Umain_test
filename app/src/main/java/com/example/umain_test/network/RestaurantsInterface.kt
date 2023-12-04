package com.example.umain_test.network

import com.example.umain_test.models.Restaurants
import retrofit2.http.GET
import javax.inject.Singleton


@Singleton
interface RestaurantsInterface {
    @GET("restaurants")
    suspend fun getAllRestaurants() : Restaurants
}


//https://food-delivery.umain.io/api/v1/restaurants