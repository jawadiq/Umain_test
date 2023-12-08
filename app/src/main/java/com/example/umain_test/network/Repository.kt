package com.example.umain_test.network

import com.example.umain_test.model.Restaurants

import com.example.umain_test.util.Resource

interface Repository {
    suspend fun getAllRestaurant(): Resource<Restaurants>
    suspend fun searchRestaurant(search:String) : Resource<Restaurants>
}