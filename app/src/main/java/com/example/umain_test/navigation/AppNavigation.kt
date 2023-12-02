package com.example.umain_test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.umain_test.screens.DetailsScreen

import com.example.umain_test.screens.HomeScreen


@Composable
fun  ApplicationNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.name ){
        composable(AppScreens.HomeScreen.name){
         HomeScreen(navController = navController )
        }
        composable(AppScreens.DetailsScreen.name){
            DetailsScreen(navController = navController)
        }
    }

}