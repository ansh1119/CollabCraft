package com.example.myapplication.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.models.User

@Composable
fun ApplicantCard(user: User,navController: NavController) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth(.9f)
            .height(60.dp)
            .clickable { navController.navigate(route = "profile/${user.username}") },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF314957),
        )
    ) {
        Column {
            Row(modifier=Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically) {
                Column(modifier=Modifier.padding(start = 10.dp)) {
                    Text(text = user.name,
                        color = Color.White)
                    Text(text = "@${user.username}",
                        color = Color(0xFFB6B6B6))
                }
                Spacer(modifier = Modifier.weight(.33f))
                Row(modifier=Modifier.padding(end = 10.dp)) {
                    Box(modifier = Modifier) {
                        when (user.domain1) {
                            "ML" -> MLChip()
                            "android" -> AndroidChip()
                            "AR/VR" -> ARVRChip()
                            "Web" -> WebChip()
                            "backend"-> WebChip()
                        }
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(modifier = Modifier) {
                        when (user.domain2) {
                            "ML" -> MLChip()
                            "Android" -> AndroidChip()
                            "AR/VR" -> ARVRChip()
                            "Web" -> WebChip()
                            "backend"-> WebChip()
                        }
                    }
                }
            }

        }
    }
}

@Composable
@Preview
fun ApplicantCardPreview() {
    var user: User = User("Cse", "mail", "Android", "ML", "ansh", "password", "username", "3")
    ApplicantCard(user = user, rememberNavController())
}
