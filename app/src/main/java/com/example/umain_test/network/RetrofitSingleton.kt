package com.example.umain_test.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    val BASE_URL = Constants.BASE_URL
    private var retrofit: Retrofit? = null

    // Method to get the Retrofit instance
    fun getInstance(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    // You can also add methods to get different API services using this Retrofit instance
//    fun getApiService(): ApiService {
//        return getInstance().create(ApiService::class.java)
//    }
}