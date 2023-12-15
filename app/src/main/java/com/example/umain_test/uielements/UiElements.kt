package com.example.umain_test.uielements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.LockClock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.SyncLock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.example.umain_test.R
import com.example.umain_test.model.Restaurant

@Composable
fun RestaurantItems(
    restaurant: Restaurant,//need to fix this
    onItemClick: (String) -> Unit = {}
//    ,
//    navController: NavController
) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp, 0.dp, 10.dp, 0.dp)
            .clickable {
                onItemClick(restaurant.name)//
//                navController.navigate(route = AppScreens.DetailsScreen.name)
//                Toast.makeText(context,restaurant.name,Toast.LENGTH_LONG).show()
//                Log.d(TAG , restaurant.id)
            },
        border = BorderStroke(1.dp, Color(0xffeff1f5)),
        //set card elevation of the card
        elevation = CardDefaults.cardElevation(
            defaultElevation = 50.dp,
        ),

        ) {

//        val resto by viewModel.rests.
        Column(verticalArrangement = Arrangement.spacedBy((-40).dp)) {
            Row(
                Modifier
                    .wrapContentSize()
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
                , horizontalArrangement =Arrangement.SpaceAround) {

                Image(
                    painter = rememberImagePainter(
                        data = restaurant.imageUrl,
                        builder = {
                            size(OriginalSize)
                        },
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

            }
            Box (Modifier.background(Color.White)) {
                Row(
                    Modifier
                        .wrapContentSize()
                        .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column (Modifier.wrapContentSize()){
                        Text(text = restaurant.name,color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = "Type  of Delivery",color = Color.Black)
                        Row {
                            androidx.compose.material3.Icon(
                                painter = painterResource(id = R.drawable.baseline_watch_later_16),
                                contentDescription = null
                            )
                            Text(text = restaurant.deliveryTimeMinutes.toString()+"Minutes"
                                ,color = Color.Black, fontSize = 12.sp)
//                            Text(text = stringResource(R.string.delivery_minutes)
//                                ,color = Color.Black, fontSize = 16.sp)
                        }
                        Icons.Filled.Star
                    }
Row(Modifier.wrapContentSize(), horizontalArrangement = Arrangement.Center ) {
    androidx.compose.material3.Icon(
        imageVector = Icons.Filled.Star,
        contentDescription = null,
        tint = Color.Yellow
    )
    Text(text = restaurant.rating.toString(),color = Color.Black,fontWeight = FontWeight.Bold,
        fontSize = 18.sp)
}


                }
            }


        }

    }

}
@Composable
fun RowCard( restaurant: Restaurant,
             onItemClick: (String) -> Unit = {}){
    Card(
        shape = RoundedCornerShape(50.dp,),
        modifier = Modifier
            .padding(5.dp)
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(5.dp, 0.dp, 5.dp, 0.dp)
            .clickable {
                onItemClick(restaurant.id)
            },
        border = BorderStroke(2.dp, Color(0xffeff1f5)),
        //set card elevation of the card
        elevation = CardDefaults.cardElevation(
            defaultElevation = 1.dp,
            ),colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F1ED),
        )
        ){
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)){
            Image(
                    painter = rememberImagePainter(
                        data = restaurant.imageUrl,
                        builder = {
                            size(OriginalSize)
                        },
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                )

            Text(text = restaurant.name, color = Color.Black,fontWeight = FontWeight.Bold)
            }


        }
}
@Composable
fun RestaurantNameCard(name: String?){
    Card(
        shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp),

        modifier = Modifier
            .padding(5.dp)
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(0.dp, 0.dp, 0.dp, 0.dp),
        border = BorderStroke(2.dp, Color(0xFFEBEDF1)),
        //set card elevation of the card
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
        ), colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F1ED),
        )
    ){
        Row(
            Modifier
                .fillMaxWidth(),
                ) {
            Column(Modifier.padding(20.dp)) {
//                Spacer(modifier = Modifier.size(50.dp))
                Text(text = name.toString(),color = Color.Black, fontSize = 30.sp)
//                Spacer(modifier = Modifier.size(15.dp))
                Text(text = stringResource(id = R.string.take_out),color = Color.Gray, fontSize = 30.sp)
//                Spacer(modifier = Modifier.size(15.dp))
                Text(text = stringResource(id = R.string.open_close),color = Color.Green, fontSize = 20.sp)
//                Spacer(modifier = Modifier.size(15.dp))
//                Text(text =  R.string.take_out, fontSize = 30.sp)
            }

        }

    }
    
}

@Composable
fun Icon(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
){

}
@Preview
@Composable
fun RestaurantNameCardPreview() {
    RestaurantNameCard("Presview")
}

@Preview
@Composable
fun RestaurantItemsPreview() {
//    RestaurantItems(restaurant = Restaurant())
}










