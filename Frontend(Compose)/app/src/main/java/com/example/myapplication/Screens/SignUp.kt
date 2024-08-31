package com.example.myapplication.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.Components.InputField

@Composable
fun SignUpScreen(onNavigateToSignUp2: () -> Unit) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var branch by remember { mutableStateOf("") }
    var firstDomain by remember { mutableStateOf("") }
    var secondDomain by remember { mutableStateOf("") }

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
                            value = username,
                            onValueChange = { username = it })
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
                onClick = {},
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


@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen(onNavigateToSignUp2 = {})
}


