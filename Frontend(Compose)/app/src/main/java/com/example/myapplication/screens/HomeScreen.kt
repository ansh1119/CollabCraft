package com.example.myapplication.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.components.Tweet
import com.example.myapplication.viewmodel.TweetViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(tweetViewModel: TweetViewModel = viewModel()) {
    // Observe the tweet list from the ViewModel
    val tweetList by tweetViewModel.tweets.collectAsState(initial = emptyList())

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(tweetList) { tweetData ->
                Tweet(tweetData)
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}
