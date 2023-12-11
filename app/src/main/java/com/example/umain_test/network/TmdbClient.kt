package com.example.umain_test.network

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.observer.ResponseObserver

import javax.inject.Inject
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.contentType



import kotlinx.serialization.json.Json

class TmdbClient @Inject constructor() {
    fun getHttpClient () = HttpClient(Android){
//        defaultRequest {
//            contentType(ContentType.Application.Json)
//            accept(ContentType.Application.Json)
//        }
install(Logging){
    logger = object : Logger {
        override fun log(message: String) {
            Log.v(TAG_KTOR_LOGGER, message)
        }

    }
    level = LogLevel.ALL

}
//        install(ContentNegotiation){
//            json(Json {
//                prettyPrint = true
//                isLenient = true
//                ignoreUnknownKeys = true
//            })
//            engine {
//                connectTimeout = TIME_OUT
//                socketTimeout = TIME_OUT
//            }
//        }

        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })

            engine {
                connectTimeout = TIME_OUT
                socketTimeout = TIME_OUT
            }
        }
        install(DefaultRequest){
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
        }

        install(Logging){
            logger = object : Logger {
                override fun log(message: String) {
                    Log.i(TAG_KTOR_LOGGER,message)
                }
            }
        }
        install(ResponseObserver) {
            onResponse { response ->
                Log.d(TAG_HTTP_STATUS_LOGER, "${response.status.value}")
            }
        }
        engine {
            connectTimeout = TIME_OUT
            socketTimeout = TIME_OUT
        }

}
    companion object {
        private const val TIME_OUT = 10000
        private const val TAG_KTOR_LOGGER = "ktor logging"
        private const val TAG_HTTP_STATUS_LOGER = "http status"
    }



    }


