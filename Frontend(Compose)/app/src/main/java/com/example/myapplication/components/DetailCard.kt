package com.example.myapplication.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DetailCard(detail:String) {

    Card(colors=CardDefaults.cardColors(Color(0xFF314957)),
        ) {
        Text(modifier=Modifier.padding(start = 7.dp,end=7.dp,top=7.dp, bottom = 6.dp),
            text = detail,
            color = Color.White)
    }
}


