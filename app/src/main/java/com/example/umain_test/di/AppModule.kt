package com.example.umain_test.di

import com.example.umain_test.network.Constants
import com.example.umain_test.network.RestaurantsInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun restauarantsApi (): RestaurantsInterface {
      return Retrofit.Builder().baseUrl(Constants.BASE_URL).
      addConverterFactory(GsonConverterFactory.create()).
      build().
      create(RestaurantsInterface::class.java)
    }

}