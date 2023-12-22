package com.example.umain_test.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AirlineSeatLegroomReduced
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.example.umain_test.R
import com.example.umain_test.network.Constants
import com.example.umain_test.uielements.RestaurantNameCard
import com.example.umain_test.viewmmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@Composable
fun  DetailsScreen(
    navController: NavController
    , restaurantId: String? ,
    resName : String?,rating :String ?
    ,imgUrl :String?,
    viewModel: MainViewModel = hiltViewModel()


){
    val mContext  = LocalContext.current

viewModel.resStatus.value?.restaurantId
        val isOpen = viewModel.resStatus.value?.isCurrentlyOpen
    val auto =  Constants.FILTER_RESTAURANTS + restaurantId
    Scaffold(
        topBar = {
            TopAppBar(
                title = {  },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Transparent),
                navigationIcon = {
                    Icon(
                       painter = painterResource(id = R.drawable.baseline_expand_circle_down_24),
                        contentDescription = null
                    )
                },
                actions = {
                    IconButton(onClick = { /* Handle action click */ }) {

                    }

                })
        }
    ){
        Surface(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(), color = Color.White) {
            Column(verticalArrangement = Arrangement.spacedBy((-40).dp)) {
                Image(
                    painter = rememberImagePainter(
                        data = imgUrl,
                        builder = {
                            size(OriginalSize)
                        },
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                RestaurantNameCard(restaurantId,resName,rating,imgUrl)

                    Text(text = isOpen.toString())
                }

            }

        }
    }


