package com.example.myapplication.screens

import UserViewModel
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.R
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.Repository.UserRepository
import com.example.myapplication.components.BottomNav
import com.example.myapplication.components.DropMenu
import com.example.myapplication.components.TopBar
import com.example.myapplication.models.Tweet
import com.example.myapplication.retrofitHelper.RetrofitInstance
import com.example.myapplication.retrofitHelper.TokenManager
import com.example.myapplication.viewModels.TweetViewModelFactory
import com.example.myapplication.viewModels.UserViewModelFactory
import com.example.myapplication.viewmodel.TweetViewModel


@Composable
fun CreateTweetScreen(navController: NavController) {

    var content by remember {
        mutableStateOf("")
    }
    var domain by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    val domainList = listOf("Android", "Web", "ML", "IOT", "AR/VR")
    val retrofitInstance: RetrofitInstance = RetrofitInstance("")

    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(UserRepository(retrofitInstance.providesUserAPI(context)))
    )
    val tweetViewModel: TweetViewModel = viewModel(
        factory = TweetViewModelFactory(ApiRepository(retrofitInstance.providesTweetAPI(context)))
    )
    val tokenManager = TokenManager(context)
    val username = tokenManager.getUsername()
    if (username != null) {
        userViewModel.getUser(username)
    }
    val user by userViewModel.user.collectAsState()
    Scaffold(topBar = {
        TopBar(
            navController = navController,
            context = context
        )
    },
        containerColor = Color(0xFF1D2A32),
        bottomBar = { BottomNav(navController = navController) }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(
                Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    DropMenu(
                        options = domainList,
                        selectedOption = domain
                    ) { selectedOption ->
                        domain = selectedOption
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 6.dp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(.9f)
                        .height(250.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFF314957),
                    )
                ) {
                    Column(modifier = Modifier.padding(start = 20.dp, top = 10.dp)) {
                        user?.let {
                            Text(
                                text = it.name,
                                color = Color.White
                            )
                        }
                        Text(
                            text = "@${username}",
                            color = Color(0xFFB6B6B6)
                        )
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TextField(value = content,
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent,
                                unfocusedContainerColor = Color.Transparent,
                                disabledContainerColor = Color.Transparent,
                                errorContainerColor = Color.Transparent,
                                cursorColor = Color.White
                            ),
                            placeholder = { Text(text = "Write Here") },
                            modifier = Modifier.fillMaxWidth(.9f),
                            onValueChange = { content = it })
                    }

                }
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Row(modifier= Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                    horizontalArrangement = Arrangement.End) {
                    Button(modifier=Modifier.size(60.dp),
                        onClick = { if(domain=="") {
                            Toast.makeText(context,"Please Select Domain",Toast.LENGTH_LONG).show()
                        }
                                  else if(content=="" || content.length<=5) {
                                      Toast.makeText(context,"Content of Collab Not Valid",Toast.LENGTH_LONG).show()
                                  }
                                  else{
                                      var tweet:Tweet= Tweet(content,domain)
                                      tweetViewModel.createTweet(tweet)
                                        Toast.makeText(context,"Collab Posted", Toast.LENGTH_LONG).show()
                                        content=""
                                        domain=""
                                  }},
                        shape = CircleShape) {
                        Icon(modifier= Modifier
                            .fillMaxSize()
                            .scale(2.2f),
                            painter = painterResource(id = R.drawable.baseline_send_24),
                            contentDescription = "")
                    }
                }
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun CreateTweetPreview() {
    CreateTweetScreen(navController = rememberNavController())
}