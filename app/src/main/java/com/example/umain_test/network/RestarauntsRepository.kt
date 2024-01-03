package com.example.umain_test.network

import com.example.umain_test.model.FilterId
import com.example.umain_test.model.RestarantStatus
import com.example.umain_test.model.Restaurant


import com.example.umain_test.util.Resource

interface RestarauntsRepository {
    suspend fun getAllRestaurants(): Resource<List<Restaurant>>

    suspend fun restaurantStatus (Id:String): RestarantStatus

suspend fun getRestaurantFilter() : List<FilterId>


}