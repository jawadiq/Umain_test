package com.example.umain_test.di


import com.example.umain_test.network.KtorApiClientIMPLE
import com.example.umain_test.network.RestarauntsRepository
import com.example.umain_test.network.TmdbClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class AppModule {

@Provides
fun getHttpClient(httpClient: TmdbClient) : HttpClient = httpClient.getHttpClient()

    @Provides
    fun getRestaraunts (impl : KtorApiClientIMPLE) : RestarauntsRepository = impl

}