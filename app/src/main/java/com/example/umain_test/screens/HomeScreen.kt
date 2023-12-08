package com.example.umain_test.screens

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import android.view.Surface
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.umain_test.R
import com.example.umain_test.navigation.AppScreens
import com.example.umain_test.network.RetrofitSingleton
import com.example.umain_test.uielements.HeaderCard
import com.example.umain_test.uielements.RowCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun HomeScreen(navController: NavController){
    Column (modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()){
        val mContext  = LocalContext.current
        Scaffold(
            topBar = {
                val mContext = LocalContext.current

                TopAppBar(
                    title = { Text(text = stringResource(R.string.head_name)) },
                    navigationIcon = {
//                    IconButton(onClick = {  }) {
//                        Icon(
//                            imageVector = Icons.Default.Menu,
//                            contentDescription = null
//                        )
//                    }
                    },
                    actions = {
                        IconButton(onClick = { /* Handle action click */ }) {
                            Icon(
                                imageVector = Icons.Default.Face,
                                contentDescription = null
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Home,
                                contentDescription = null
                            )
                        }
                    })
            }
        ){
            MainContent(navController = navController)

                }

            }

        }




@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun MainContent(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        UpperRow(navController = navController)
        lowerColumn(navController = navController)
    }


}

    @RequiresApi(Build.VERSION_CODES.R)
    @Composable
    fun lowerColumn(
        testList: List<String> = listOf(
            "one", "two", "three", "four","four","four"
        ), navController: NavController
    ) {
        val mContext = LocalContext.current

        LazyColumn {
            items(items = testList) {
                HeaderCard(test = it) {
//            test ->
//      mytoast(mContext,test)

                    navController.navigate(route = AppScreens.DetailsScreen.name)

                }

            }

        }
    }
@Composable
fun UpperRow(testList : List<String> = listOf(
    "one","two","three","four",
),navController: NavController) {
    Row(
        androidx.compose.ui.Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(0.dp, 60.dp, 0.dp, 0.dp)
    ) {
        LazyRow {
            items(items = testList) {
               RowCard(test = it) {
//            test ->
//      mytoast(mContext,test)

                    navController.navigate(route = AppScreens.DetailsScreen.name)

                }
            }
        }
    }
}

    fun mytoast(context: Context, messege: String) {
        Toast.makeText(context, messege, Toast.LENGTH_LONG).show()
        RetrofitSingleton.getInstance()
    }
