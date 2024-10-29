package com.example.myapplication.screens

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.components.Tweet
import com.example.myapplication.retrofitHelper.RetrofitInstance
import com.example.myapplication.viewModels.TweetViewModelFactory
import com.example.myapplication.viewmodel.TweetViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    val context:Context= LocalContext.current
    val retrofitInstance:RetrofitInstance= RetrofitInstance("")


    val tweetViewModel:TweetViewModel= viewModel(
        factory = TweetViewModelFactory(ApiRepository(retrofitInstance.providesTweetAPI(context)))
    )

    val tweetList = tweetViewModel.tweets.collectAsState()
    Log.d("I AM HERE","working good")
    Scaffold{
        innerPadding->
        Box(modifier = Modifier.padding(innerPadding)) {
            LazyColumn {
                items(tweetList.value) { tweetData ->
                    Tweet(tweetData, tweetViewModel)
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){

    HomeScreen(navController = rememberNavController())
}


