package com.example.umain_test.uielements

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HeaderCard (test :String,
                onItemClicke : (String) -> Unit = {}
){
    Card(
        shape = RoundedCornerShape(10.dp,10.dp,0.dp,0.dp),

        modifier = Modifier.padding(5.dp).fillMaxWidth().wrapContentHeight().clickable{
onItemClicke(test)
        },
        border = BorderStroke(1.dp, Color(0xFFAAC7F5)),
        //set card elevation of the card
        elevation = CardDefaults.cardElevation(
            defaultElevation =  50.dp,
        ),
//        colors = CardDefaults.cardColors(
//            containerColor =   Color(0x993B6085),
//        ),
    ){


        Text(text = test)

    }

}