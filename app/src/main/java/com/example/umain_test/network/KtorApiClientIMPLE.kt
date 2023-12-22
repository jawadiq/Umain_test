package com.example.umain_test.network


import com.example.umain_test.model.AllRestaurants
import com.example.umain_test.model.RestarantStatus
import com.example.umain_test.model.Restaurant
import com.example.umain_test.util.Resource
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.takeFrom
import javax.inject.Inject

class KtorApiClientIMPLE @Inject constructor(
    private val myClient: HttpClient
) : RestarauntsRepository {
    override suspend fun getAllRestaurants(): Resource<List<Restaurant>> {
        return try {
            Resource.Success(
                myClient.get<AllRestaurants> {
                    url(Constants.RESTAURANTS)
                }.restaurants
            )

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Failure(e)
        }
    }

    override suspend fun restaurantStatus(): RestarantStatus {


        return myClient.get {
            url {
                takeFrom(Constants.RESTAURANT_STATUS+7450007)
            }
        }
    }
}
//    override suspend fun getRestaurant(): List<Restaurant> {
//        TODO("Not yet implemented")
//
//    }override suspend fun searchRestaurants(search: String): Resource<AllRestaurants> {
//        TODO("Not yet implemented")
//}
//
//    override suspend fun filterRestaurants(search: String): Resource<Restaurant> {
//        return try {
//            Resource.Success(
//                myClient.get{
//                    url(Constants.FILTER_RESTAURANTS)
//                }
//            )
//        }catch (e : Exception){
//            e.printStackTrace()
//            Resource.Failure(e)
//        }
//    }


