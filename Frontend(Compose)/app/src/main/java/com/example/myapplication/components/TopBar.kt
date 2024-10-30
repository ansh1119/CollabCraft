package com.example.myapplication.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.retrofitHelper.TokenManager

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController,context:Context) {
    val tokenManager=TokenManager(context)
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0xFF1D2A32),
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Spacer(modifier = Modifier.width(30.dp))
                    Image(
                        painter = painterResource(id = R.drawable.colabcraft),
                        contentDescription = "",
                        modifier = Modifier.scale(2.5f)
                    )
                    Spacer(modifier = Modifier.weight(0.33f))
                    Button(modifier=Modifier.padding(end = 10.dp),
                        onClick = { tokenManager.clearData()
                    navController.navigate(route = "login")}) {

                    }
                }

            }


        }
    )
}