package com.example.umain_test.screens

import android.content.Context
import android.os.Build
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.umain_test.navigation.AppScreens
import com.example.umain_test.network.RetrofitSingleton
import com.example.umain_test.uielements.HeaderCard

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun HomeScreen(navController: NavController){
    val mContext  = LocalContext.current
Surface(
    Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
    Column (
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()){
       lowerColumn(navController = navController)
    }

}
   
}
@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun lowerColumn(testList : List<String> = listOf(
    "one","two","three"
),navController: NavController){
    val mContext  = LocalContext.current

    LazyColumn {
        items (items = testList){ HeaderCard(test = it){
//            test ->
//      mytoast(mContext,test)

            navController.navigate(route = AppScreens.DetailsScreen.name)

        }

        }

    }
}

fun mytoast(context: Context, messege: String) {
    Toast.makeText(context, messege, Toast.LENGTH_LONG).show()
    RetrofitSingleton.getInstance()
}