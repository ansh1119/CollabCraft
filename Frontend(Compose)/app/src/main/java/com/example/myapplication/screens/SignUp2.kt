@file:JvmName("SignUp2Kt")

package com.example.myapplication.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.Repository.PublicRepository
import com.example.myapplication.components.InputField
import com.example.myapplication.models.User
import com.example.myapplication.retrofitHelper.RetrofitInstance
import com.example.myapplication.viewModels.PublicViewModel
import com.example.myapplication.viewModels.PublicViewModelFactory

@Composable
fun SignUp2(navController: NavController, username:String, password:String) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var branch by remember { mutableStateOf("") }
    var firstDomain by remember { mutableStateOf("") }
    var secondDomain by remember { mutableStateOf("") }

//    val userViewModel: UserViewModel = viewModel(
//        factory = PublicViewModelFactory(ApiRepository(RetrofitInstance.api))
//    )

    val retrofitInstance:RetrofitInstance= RetrofitInstance()

    val publicViewModel:PublicViewModel= viewModel(
        factory = PublicViewModelFactory(
            PublicRepository(retrofitInstance.providesPublicApiService())
        )
    )


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF1D2A32)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Create Your Account.",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 20.dp, top = 40.dp)
                )

                Card(
                    colors = CardDefaults.cardColors(containerColor = Color(0xff314957)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 40.dp)
                ) {
                    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
                        InputField(
                            label = "Name",
                            value = name,
                            onValueChange = { name = it })
                        InputField(
                            label = "College Email ID",
                            value = email,
                            onValueChange = { email = it })
                        InputField(label = "Year", value = year, onValueChange = { year = it })
                        InputField(
                            label = "Branch",
                            value = branch,
                            onValueChange = { branch = it })
                        InputField(
                            label = "First Domain",
                            value = firstDomain,
                            onValueChange = { firstDomain = it })
                        InputField(
                            label = "Second Domain (Optional)",
                            value = secondDomain,
                            onValueChange = { secondDomain = it })
                    }
                }
            }

            IconButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(end = 6.dp)
                    .background(
                        color = Color(0xff586B76),
                        shape = CircleShape
                    )  // Optional background color
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "Previous",
                    tint = Color(0xff00E0FF)
                )
            }

            // Right arrow on SignUp screen (non-functional)
            IconButton(
                onClick = {
                    val user = User(branch, email, firstDomain, secondDomain, name, password, username, year)
                    Log.d("USER CREATED", user.toString())

                    publicViewModel.createUser(
                        user = user,
                        onSuccess = {
                            Log.d("SIGN UP", "User created successfully!")
                            navController.navigate("login") // Navigate only after success
                        },
                        onError = { error ->
                            Log.e("SIGN UP", "Failed to create user: $error")
                            // Show an error message to the user (e.g., Snackbar or Toast)
                        }
                    )
                },
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 6.dp)
                    .background(
                        color = Color(0xff586B76),
                        shape = CircleShape
                    )  // Optional background color
            ) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "Next",
                    tint = Color(0xff00E0FF)
                )
            }
        }
    }
}




