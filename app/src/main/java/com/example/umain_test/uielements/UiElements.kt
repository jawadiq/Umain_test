package com.example.umain_test.uielements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.example.umain_test.model.AllRestaurants

@Composable
fun HeaderCard(restarant: AllRestaurants) {


    Card(
        shape = RoundedCornerShape(10.dp, 10.dp, 0.dp, 0.dp),

        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp, 0.dp, 10.dp, 0.dp)
            .clickable {
//                onItemClicke()
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
                        data = "https://food-delivery.umain.io/images/restaurant/burgers.png",
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
                        .fillMaxWidth()) {
                    Column (Modifier.wrapContentSize()){
                        Text(text = "Restaurant name")
                        Text(text = "type of delivery")
                        Text(text = "time of delivery of delivery")
                    }

                    Text(text = "Rating bar")
                }
            }


        }

    }

}
@Composable
fun RowCard( test: String,
             onItemClick: (String) -> Unit = {}){
    Card(
        shape = RoundedCornerShape(50.dp,),

        modifier = Modifier
            .padding(5.dp)
            .wrapContentWidth()
            .wrapContentHeight()
            .padding(10.dp, 0.dp, 10.dp, 0.dp)
            .clickable {
                onItemClick(test)
            },
        border = BorderStroke(2.dp, Color(0xffeff1f5)),
        //set card elevation of the card
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
        ),
        ){
        Row (verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(5.dp)){
            Image(
                    painter = rememberImagePainter(
                        data = "https://food-delivery.umain.io/images/restaurant/beer.png",
                        builder = {
                            size(OriginalSize)
                        },
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier.clip(CircleShape).size(50.dp)
                )

            Text(text = "Restaurant type", color = Color.Blue,fontWeight = FontWeight.Bold)
            }


        }



    }





