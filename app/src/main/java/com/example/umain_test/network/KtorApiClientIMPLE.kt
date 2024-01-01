package com.example.umain_test.network


import com.example.umain_test.model.AllRestaurants
import com.example.umain_test.model.FilterId
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
        finally {
            myClient.close()
        }
    }
    
    override suspend fun restaurantStatus(Id:String): RestarantStatus {
        return myClient.get {
            url {
                takeFrom(Constants.RESTAURANT_STATUS+Id)
            }
        }
    }

//    override suspend fun restaurantFilter(): FilterId {
//       return myClient.get{
//           url(Constants.FILTER_RESTAURANTS)
//       }
//    }

//    override suspend fun filterRestaurant(): Resource<List<FilterId>> {
//        return try {
//            Resource.Success(
//                myClient.get<Restaurant> {
//                  url(Constants.FILTER_RESTAURANTS)
//                }.filterIds
//            )
//
//        } catch (e: Exception) {
//            e.printStackTrace()
//            Resource.Failure(e)
//        }
//    }
}



