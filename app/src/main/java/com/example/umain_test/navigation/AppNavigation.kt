package com.example.umain_test.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.umain_test.screens.DetailsScreen

import com.example.umain_test.screens.HomeScreen


@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun  ApplicationNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.HomeScreen.name){
        composable(AppScreens.HomeScreen.name){
         HomeScreen(navController = navController)
        }
        composable(AppScreens.DetailsScreen.name+"/{restarantId}",
            arguments = listOf(navArgument(name = "restarantId"){type = NavType.StringType}

                )){

                backStackEntry ->
            val restId = backStackEntry.arguments?.getString("restarantId")
            val restNamme = backStackEntry.arguments?.getString("name_Key")
            DetailsScreen(navController = navController, restaurantId = restId,  resName = restNamme )

        }
    }

}