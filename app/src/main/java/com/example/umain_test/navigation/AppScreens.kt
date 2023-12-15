package com.example.umain_test.navigation

import android.net.Uri

enum class AppScreens {
    HomeScreen,DetailsScreen;
    companion object {
        fun fromRoute(route : String?): AppScreens
                = when(route?.
        substringBefore("/")){
            HomeScreen.name -> HomeScreen
           DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalAccessError("Rout is not defined")

        }


    }
}