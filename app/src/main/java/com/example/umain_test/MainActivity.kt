package com.example.umain_test

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext

import com.example.umain_test.navigation.ApplicationNavigation
import com.example.umain_test.ui.theme.Umain_testTheme
import com.example.umain_test.uielements.HeaderCard
import com.example.umain_test.util.Resource
import com.example.umain_test.viewmmodel.MainViewModel

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val restaurant = viewModel.restaurants.collectAsState()
            val context = LocalContext.current
            MainApp {
                restaurant.value?.let {
                    when (it) {
                        is Resource.Failure -> {
                  Toast.makeText(context,it.exception.message!!, Toast.LENGTH_LONG).show()
                            Text(text = "it.exception.message!!")
                            Log.d("error",it.exception.message!! )
                        }

                        Resource.Loading -> {

                        }

                        is Resource.Success -> {
//                    RestaurantsList(it.result )
//                            Toast.makeText(context,it.result.size, Toast.LENGTH_LONG).show()
                        }


                    }

                }
                ApplicationNavigation()
            }

        }
    }


    @Composable
    fun MainApp(content: @Composable () -> Unit) {
        Umain_testTheme {
            content()
        }
    }
}

