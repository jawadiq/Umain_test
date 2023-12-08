package com.example.umain_test.viewmmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.umain_test.model.Restaurants


import com.example.umain_test.network.Constants
import com.example.umain_test.network.RestaurantsInterface
import kotlinx.coroutines.launch

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel () : ViewModel() {
    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiService = retrofit.create(RestaurantsInterface::class.java)

    
    private val _rests = MutableLiveData<Restaurants>()
    val rests : LiveData<Restaurants> = _rests

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = apiService.getAllRestaurants()
                _rests.value = response.get(1)

            }catch (e: Exception){

            }
        }

}}