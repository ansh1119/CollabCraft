package com.example.myapplication.screens

import UserViewModel
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.Repository.UserRepository
import com.example.myapplication.components.ApplicantCard
import com.example.myapplication.components.TopBar
import com.example.myapplication.components.Tweet
import com.example.myapplication.retrofitHelper.RetrofitInstance
import com.example.myapplication.viewModels.TweetViewModelFactory
import com.example.myapplication.viewModels.UserViewModelFactory
import com.example.myapplication.viewmodel.TweetViewModel

@Composable
fun ApplicantsListScreen(navController: NavController,id:String) {

    val context: Context = LocalContext.current
    val retrofitInstance: RetrofitInstance = RetrofitInstance("")


    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(UserRepository(retrofitInstance.providesUserAPI(context)))
    )

    userViewModel.getApplicants(id)
    val applicantList=userViewModel.applicants

    Scaffold(topBar = {TopBar(navController = navController, context = context)}) { innerPadding->
        Box(modifier = Modifier.padding(innerPadding)){
            LazyColumn(horizontalAlignment = Alignment.CenterHorizontally,
                modifier=Modifier.padding(bottom = 15.dp)) {
                items(applicantList.value.reversed()) { user -> //reversed to get the latest colab first
                    Spacer(modifier = Modifier.height(10.dp))
                    ApplicantCard(user, navController = navController)
                    Spacer(modifier = Modifier.height(10.dp))
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFF586B76)
                    )
                }
            }

        }

    }

}