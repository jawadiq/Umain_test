package com.example.umain_test.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.umain_test.navigation.AppScreens

@Composable
fun HomeScreen(navController: NavController){
    val mContext  = LocalContext.current

    Button(onClick = {navController.navigate(route = AppScreens.DetailsScreen.name) }

    ) {
        Text(text = "Details Screen")
    }
}

fun mytoast(context: Context, messege: String) {
    Toast.makeText(context, messege, Toast.LENGTH_LONG).show()
}