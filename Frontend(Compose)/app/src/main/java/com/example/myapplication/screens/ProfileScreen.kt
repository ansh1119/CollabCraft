package com.example.myapplication.screens

import UserViewModel
import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.Repository.UserRepository
import com.example.myapplication.components.AndroidChip
import com.example.myapplication.components.BottomNav
import com.example.myapplication.components.DetailCard
import com.example.myapplication.components.MLChip
import com.example.myapplication.components.TopBar
import com.example.myapplication.components.Tweet
import com.example.myapplication.components.WebChip
import com.example.myapplication.components.upperBorder
import com.example.myapplication.models.User
import com.example.myapplication.retrofitHelper.RetrofitInstance
import com.example.myapplication.retrofitHelper.TokenManager
import com.example.myapplication.viewModels.TweetViewModelFactory
import com.example.myapplication.viewModels.UserViewModelFactory
import com.example.myapplication.viewmodel.TweetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController, username: String) {
    val context: Context = LocalContext.current
    val retrofitInstance: RetrofitInstance = RetrofitInstance("")


    val tweetViewModel: TweetViewModel = viewModel(
        factory = TweetViewModelFactory(ApiRepository(retrofitInstance.providesTweetAPI(context)))
    )

    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(UserRepository(retrofitInstance.providesUserAPI(context)))
    )
//
//    username.let { userViewModel.getUser(it) }
//    val user by userViewModel.user.collectAsState()

    userViewModel.getUser(username)
    Log.d("USERNAME DEKHO",username)
    val user by userViewModel.user.collectAsState()

    Log.d("USER CALL", user.toString())

    tweetViewModel.getTweetsOfUser(username)
    Log.d("CALL 1", "Start of screen") // Will only log once

    val tweetList = tweetViewModel.tweetsOfUser.collectAsState()


    Scaffold(
        topBar = {
            TopBar(navController = navController, context = context)
        },
        bottomBar = {
            NavigationBar(modifier = Modifier.fillMaxWidth()) {
                BottomNav(navController = navController)
            }
        },
        containerColor = Color(0xFF1D2A32)
    ) { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = R.drawable.rectangle),
                    contentDescription = ""
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        user?.name?.let {
                            Text(
                                text = it,
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                        Spacer(modifier = Modifier.weight(0.33f))
                        Box(modifier = Modifier.padding(end = 10.dp)) {
                            when (user?.domain1) {
                                "ML" -> MLChip()
                                "android" -> AndroidChip()
                                "web" -> WebChip()
                            }
                        }
                        Box(modifier = Modifier.padding(end = 30.dp)) {
                            when (user?.domain2) {
                                "ML" -> MLChip()
                                "android" -> AndroidChip()
                                "web" -> WebChip()
                                "backend" -> WebChip()
                            }
                        }

                    }

                    Text(
                        text = "@${user?.username}",
                        color = Color(0xFFB6B6B6)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    DetailCard(detail = "Bachelor of Technology")
                    Spacer(modifier = Modifier.height(15.dp))
                    Row {
                        user?.let { DetailCard(detail = it.branch) }
                        Spacer(modifier = Modifier.width(15.dp))
                        DetailCard(detail = "Year ${user?.year}")
                    }
                }
                Spacer(modifier = Modifier.height(15.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.upperBorder(3.dp, Color(0xFF00E0FF)),
                        text = "Your Posts",
                        color = Color(0xFF00E0FF),
                        fontSize = 20.sp
                    )
                }

                Box(modifier = Modifier.upperBorder(3.dp, Color(0xFF00E0FF))) {

                }

                HorizontalDivider(modifier = Modifier.fillMaxWidth())

                Spacer(modifier = Modifier.height(10.dp))
                LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
                    items(tweetList.value.reversed()) { tweetData -> //reversed to get the latest colab first
                        Column(
                            modifier = Modifier.clickable {
                                navController.navigate("applicants/${tweetData.id}")
                            },
                            horizontalAlignment = Alignment.CenterHorizontally
                        )
                        {
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


}