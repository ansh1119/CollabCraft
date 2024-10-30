package com.example.myapplication.screens

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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.Repository.PublicRepository
import com.example.myapplication.models.LoginRequest
import com.example.myapplication.retrofitHelper.RetrofitInstance
import com.example.myapplication.retrofitHelper.TokenManager
import com.example.myapplication.viewModels.PublicViewModel
import com.example.myapplication.viewModels.PublicViewModelFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController) {
    val Comissioner = FontFamily(
        Font(R.font.comissioner)
    )


    val context = LocalContext.current
    val tokenManager = TokenManager(context)


    val publicViewModel: PublicViewModel = viewModel(
        factory = PublicViewModelFactory(PublicRepository(RetrofitInstance().providesPublicApiService()))
    )



    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var remember by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .scale(1.2f)
                .verticalScroll(rememberScrollState()),
            painter = painterResource(id = R.drawable.backgroundlogin),
            contentDescription = ""
        )
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(70.dp))
//                Text(
//                    modifier = Modifier
//                        .fillMaxWidth(.8f),
//                    text = "Welcome to\nCoLabCraft",
//                    textAlign = TextAlign.Left,
//                    color = Color.White,
//                    fontSize = 44.sp
//                )
                Text(
                    fontFamily = Comissioner,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth(.8f),
                    text = "Welcome to",
                    textAlign = TextAlign.Left,
                    color = Color.White,
                    fontSize = 44.sp
                )
                Text(
                    fontFamily = Comissioner,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth(.8f),
                    text = "CollabCraft",
                    textAlign = TextAlign.Left,
                    color = Color.White,
                    fontSize = 44.sp
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    fontFamily = Comissioner,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .fillMaxWidth(.8f),
                    text = "Sign in to your account",
                    fontSize = 24.sp,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(50.dp))

                Row {
                    Spacer(modifier = Modifier.weight(.1f))

                    Card(
                        modifier = Modifier
                            .weight(.85f),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF314957)),
                    ) {
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            modifier = Modifier.padding(top = 25.dp, start = 35.dp),
                            text = "Username",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(.8f)
                                .align(Alignment.CenterHorizontally),
                            label = {
                                Text(text = "Username")
                            },
                            value = username,
                            onValueChange = { username = it },
                            shape = RoundedCornerShape(12.dp),
                            leadingIcon = {
                                Image(
                                    modifier = Modifier.scale(3f),
                                    painter = painterResource(id = R.drawable.vectorperson),
                                    contentDescription = ""
                                )
                            }
                        )
                        Text(
                            modifier = Modifier.padding(top = 25.dp, start = 35.dp),
                            text = "Password",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(.8f)
                                .height(60.dp)
                                .align(Alignment.CenterHorizontally),
                            value = password,
                            label = { Text(text = "Password")},
                            onValueChange = { password = it },
                            shape = RoundedCornerShape(12.dp),
                            leadingIcon = {
                                Image(
                                    modifier = Modifier.scale(3f),
                                    painter = painterResource(id = R.drawable.vectorlock),
                                    contentDescription = ""
                                )
                            }
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Checkbox(modifier = Modifier.padding(start = 24.dp),
                                checked = remember,
                                onCheckedChange = { remember = it })
                            Text(
                                text = "Remember Me",
                                fontSize = 12.sp,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.weight(.1f))
                            Text(
                                modifier = Modifier
                                    .padding(end = 20.dp),
                                text = "Forgot Password",
                                fontSize = 8.sp,
                                color = Color(0xFF00E0FF)
                            )
                        }
                        Button(modifier = Modifier
                            .fillMaxWidth(.8f)
                            .align(Alignment.CenterHorizontally)
                            .shadow(
                                elevation = 10.dp,
                                spotColor = Color(0xFF00E0FF),
                                ambientColor = Color.White,
                                shape = RoundedCornerShape(28.dp)
                            ),
                            shape = RoundedCornerShape(28.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFF00E0FF)),
                            onClick = {
                                tokenManager.saveUsername(username)

                                publicViewModel.login(
                                LoginRequest(username,password),
                                onSuccess = {
                                    navController.navigate("homescreen")
                                },
                                tokenManager = tokenManager,
                                onError = { message ->
                                    // Display an error message (e.g., using a Snackbar)
                                    println(message)
                                }
                            ) }) {
                            Text(text = "Sign In")
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Divider(modifier = Modifier.weight(.4f),
                                color = Color(0xFF586B76))
                            Text(
                                modifier = Modifier.weight(.2f),
                                textAlign = TextAlign.Center,
                                color = Color.White,
                                fontSize = 12.sp,
                                text = "or"
                            )
                            Divider(modifier = Modifier.weight(.4f),
                                color = Color(0xFF586B76))
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        OutlinedButton(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth(.8f)
                                .align(Alignment.CenterHorizontally)
                        ) {
//                    Image(painter = , contentDescription = )
                            Text(text = "Sign in with Google Account")
                        }
                        Spacer(modifier = Modifier.height(20.dp))

                    }
                    Spacer(modifier = Modifier.weight(.1f))
                }
                Spacer(modifier = Modifier.weight(.05f))
                Row {
                    Spacer(modifier = Modifier.weight(.1f))
                    Card(
                        modifier = Modifier.weight(.8f),
                        colors = CardDefaults.cardColors(Color(0xFF314957))
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(20.dp)
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Don't have an account?",
                                color = Color.White
                            )
                            Text(
                                modifier=Modifier.clickable {
                                    navController.navigate(route = "sign-up")
                                },
                                text = "Sign Up",
                                color = Color(0xFF00E0FF)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.weight(.1f))
                }

                Spacer(modifier = Modifier.weight(.1f))
            }
        }
    }

@Composable
@Preview
fun LoginScreenPreview(){
    LoginScreen(navController = rememberNavController())
}