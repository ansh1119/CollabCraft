package com.example.myapplication.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun SignUpScreen() {
    var username by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var year by remember {
        mutableStateOf("")
    }
    var branch by remember {
        mutableStateOf("")
    }
    var firstDomain by remember {
        mutableStateOf("")
    }
    var secondDomain by remember {
        mutableStateOf("")
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(color = 0xFF1D2A32))
    {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Create Your Account.",
                color = Color.White, fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    start = 20.dp,
                    top = 40.dp,),
                )

            Card(
                colors = CardDefaults.cardColors(containerColor = Color(color = 0xff314957)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            ) {

                Column(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                ) {

                    Row{
                        Text(text = "Name", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                        Text(text = " *", fontSize = 16.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(value =username ,
                        onValueChange = {
                            username = it
                        },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(50.dp),
                        placeholder = ({
                            Text(text = "Name", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
                        })
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row{
                        Text(text = "College Email ID", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                        Text(text = " *", fontSize = 16.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(value =email ,
                        onValueChange = {
                            email = it
                        },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(50.dp),
                        placeholder = ({
                            Text(text = "Email ID", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
                        })
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row{
                        Text(text = "Year", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                        Text(text = " *", fontSize = 16.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(value =year ,
                        onValueChange = {
                            year = it
                        },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(50.dp),
                        placeholder = ({
                            Text(text = "Year", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
                        })
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row{
                        Text(text = "Branch", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                        Text(text = " *", fontSize = 16.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(value =branch ,
                        onValueChange = {
                            branch = it
                        },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(55.dp),
                        placeholder = ({
                            Text(text = "Branch", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
                        })
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row{
                        Text(text = "First Domain", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                        Text(text = " *", fontSize = 16.sp, color = Color.Red, fontWeight = FontWeight.SemiBold)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(value =firstDomain ,
                        onValueChange = {
                            firstDomain = it
                        },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(55.dp),
                        placeholder = ({
                            Text(text = "First Domain", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
                        })
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row{
                        Text(text = "Second Domain", fontSize = 16.sp, color = Color.White, fontWeight = FontWeight.SemiBold)
                        Text(text = " (Optional)", fontSize = 16.sp, color = Color.LightGray, fontWeight = FontWeight.Medium)
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(value =secondDomain ,
                        onValueChange = {
                            secondDomain = it
                        },
                        shape = RoundedCornerShape(15.dp),
                        modifier = Modifier.height(55.dp),
                        placeholder = ({
                            Text(text = "Second Domain", fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Medium)
                        })
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                }
            }
        }
    }
}