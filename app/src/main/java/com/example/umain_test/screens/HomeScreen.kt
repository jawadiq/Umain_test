package com.example.umain_test.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.umain_test.R

import com.example.umain_test.uielements.RowCard
import com.example.umain_test.util.Resource
import com.example.umain_test.viewmmodel.MainViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.umain_test.model.Restaurant
import com.example.umain_test.navigation.AppScreens
import com.example.umain_test.uielements.RestaurantItems


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.R)
@Composable

fun HomeScreen(navController: NavController) {
    val mContext = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = stringResource(R.string.head_name)) },
                    navigationIcon = {
                    },
                    actions = {
                        IconButton(onClick = { /* Handle action click */ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null
                            )
                        }

                    })
            }
        ) {
            MainContent(navController = navController)
        }

    }

}

@SuppressLint("StateFlowValueCalledInComposition")
@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun MainContent(navController: NavController) {
    val viewModel: MainViewModel = hiltViewModel()
    val restaurant = viewModel.restaurants.collectAsState()
    val context = LocalContext.current
//    val filterId  = viewModel.resFilter.value
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        var isVisible by remember {
            mutableStateOf(false)
        }

        restaurant.value.let {
            when (it) {
                is Resource.Success -> {
                    UpperRow(it.result)
                    RestaurantsList(it.result, navController)
//                    Text(text = filterId?.name.toString())
                }

                is Resource.Failure -> {
//                    Toast.makeText(context, it.exception.message!!, Toast.LENGTH_LONG).show()
                    Log.d("error", it.exception.message!!)
                    Text(text = it.exception.message.toString(), Modifier.fillMaxSize())

//                    DisplayErrorMessage(errorMessages)
                }
                Resource.Loading -> {
                    Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                }

                else -> {

                }
            }
        }

    }
}
@Composable
fun DisplayErrorMessage(errorMessages: List<String>) {
    LazyColumn {
        items(errorMessages) { errorMessage ->
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                BasicTextField(
                    value = errorMessage,
                    onValueChange = { },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun RestaurantsList(restaurants: List<Restaurant>, navController: NavController) {
    val context = LocalContext.current

    LazyColumn {
        items(items = restaurants) { item ->
            RestaurantItems(item)
            { id, name, rating, test ->
                navController.navigate(
                    route = AppScreens.DetailsScreen.name + "/$id"
                            + "/$name"
                            + "/$rating"
                            + "/$test"

                );


            }
        }


    }
}

@Composable
fun UpperRow(restaurants: List<Restaurant>) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(0.dp, 60.dp, 0.dp, 0.dp)
    ) {
        LazyRow {
            items(items = restaurants) {
                RowCard(restaurant = it) {

                }
            }
        }
    }
}

fun mytoast(context: Context, messege: String) {
    Toast.makeText(context, messege, Toast.LENGTH_LONG).show()

}

