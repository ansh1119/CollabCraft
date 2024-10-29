package com.example.myapplication.screens

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.components.BottomNav
import com.example.myapplication.components.DropMenu
import com.example.myapplication.components.Tweet
import com.example.myapplication.models.BottomNavItem
import com.example.myapplication.retrofitHelper.RetrofitInstance
import com.example.myapplication.viewModels.TweetViewModelFactory
import com.example.myapplication.viewmodel.TweetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    val context: Context = LocalContext.current
    val retrofitInstance: RetrofitInstance = RetrofitInstance("")


    val tweetViewModel: TweetViewModel = viewModel(
        factory = TweetViewModelFactory(ApiRepository(retrofitInstance.providesTweetAPI(context)))
    )


    var selected by remember {
        mutableStateOf(0)
    }
    val domainList = listOf("All", "android", "Web", "ml", "iot", "AR/VR")

    var domain by remember {
        mutableStateOf("")
    }

    val tweetList = tweetViewModel.tweets.collectAsState()



    Log.d("I AM HERE", "working good")
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1D2A32),
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Column {
                        Row {
                            Spacer(modifier = Modifier.width(30.dp))
                            Image(
                                painter = painterResource(id = R.drawable.colabcraft),
                                contentDescription = "",
                                modifier = Modifier.scale(2.5f)
                            )
                        }

                    }


                }
            )
        },
        bottomBar = {
            NavigationBar(modifier = Modifier.fillMaxWidth()) {
                BottomNav(navController = navController)
            }
        },
        containerColor = Color(0xFF1D2A32)
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    DropMenu(
                        options = domainList,
                        selectedOption = domain
                    ) { selectedOption ->
                        domain = selectedOption
                        Log.d("CHANGE", "DOMAIN CHANGED TO $domain")
                        if (domain == "All") {
                            tweetViewModel.getTweets() // No domain selected, fetch all tweets
                        } else {
                            tweetViewModel.getTweetsByDomain(domain) // Fetch tweets by selected domain
                        }

                    }
                }
                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color(0xFF586B76)
                )
                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn {
                    items(tweetList.value.reversed()) { tweetData -> //reversed to get the latest colab first
                        Spacer(modifier = Modifier.height(10.dp))
                        Tweet(tweetData, tweetViewModel)
                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = Color(0xFF586B76)
                        )
                    }
                }
            }

        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {

    HomeScreen(navController = rememberNavController())
}


