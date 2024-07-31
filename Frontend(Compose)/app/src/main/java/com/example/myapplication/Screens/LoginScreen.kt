package com.example.myapplication.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun LoginScreen() {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var remember by remember {
        mutableStateOf(false)
    }
    Surface(modifier=Modifier.fillMaxSize(),
        color = Color(color = 0xFF1D2A32)) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.weight(.1f))
            Text(text = "Welcome to\nCoLabCraft",
                color = Color.White,
                fontSize = 44.sp,
                modifier = Modifier.weight(.1f))
            Text(text = "Sign in to your account",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.weight(.1f))

            Row {
                Spacer(modifier = Modifier.weight(.2f))

                Card(
                    modifier=Modifier.weight(.6f),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF314957)),
                ) {
                    Text(
                        text = "Username",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    OutlinedTextField(
                        value = username,
                        onValueChange = { username = it },
                        shape = RoundedCornerShape(28.dp)
                    )
                    Text(
                        text = "Password",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        shape = RoundedCornerShape(28.dp)
                    )
                    Row {
                        Checkbox(checked = remember,
                            onCheckedChange = { remember = it })
                        Text(
                            text = "Remember Me",
                            fontSize = 8.sp,
                            color = Color.White
                        )
                        Text(
                            text = "Forgot Password",
                            fontSize = 8.sp,
                            color = Color(0xFF00E0FF)
                        )
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Sign In")
                    }
                    Row {
                        Divider()
                        Text(text = "or")
                        Divider()
                    }
                    Button(onClick = { /*TODO*/ }) {
//                    Image(painter = , contentDescription = )
                        Text(text = "Sign in with Google Account")

                    }

                }
            }
            Card(modifier=Modifier.weight(.2f)) {
                Row {
                    Text(text = "Don't have an account?")
                    Text(text = "Sign Up")
                }
            }
        }
    }
}