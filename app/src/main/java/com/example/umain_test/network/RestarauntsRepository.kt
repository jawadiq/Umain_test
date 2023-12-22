package com.example.umain_test.network

import com.example.umain_test.model.AllRestaurants
import com.example.umain_test.model.RestarantStatus
import com.example.umain_test.model.Restaurant


import com.example.umain_test.util.Resource

interface RestarauntsRepository {
    suspend fun getAllRestaurants(): Resource<List<Restaurant>>
//    suspend fun getRestaurant () : List<Restaurant>
//    suspend fun searchRestaurants(search:String) : Resource<AllRestaurants>
//    suspend fun filterRestaurants(search:String) : Resource<Restaurant>

    suspend fun restaurantStatus (): RestarantStatus


}