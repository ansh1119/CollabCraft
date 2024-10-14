package com.example.myapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.components.DropMenu

@Preview
@Composable
fun CreateTweetScreen() {

    var content by remember {
        mutableStateOf("")
    }
    var domain by remember{
        mutableStateOf("")
    }

    val domainList= listOf("android","Web","ml","iot","AR/VR")

    Column(modifier= Modifier.fillMaxSize()) {
        DropMenu(options = domainList, selectedOption = domain) {

        }
        Card(modifier = Modifier.fillMaxWidth(.8f)
            .height(200.dp)) {
            TextField(value = content, onValueChange = {content=it})
        }
    }
}