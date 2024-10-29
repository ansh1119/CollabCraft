package com.example.myapplication.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.models.BottomNavItem

@Composable
fun BottomNav(navController: NavController) {
    val bottomNavItems= listOf(
        BottomNavItem(route ="home", selectedIcon = R.drawable.homeon, unselectedIcon = R.drawable.home),
        BottomNavItem(route="create", selectedIcon = R.drawable.addon, unselectedIcon = R.drawable.add),
        BottomNavItem(route = "profile", selectedIcon = R.drawable.useron, unselectedIcon = R.drawable.maleuser)
    )

    var selected by remember{
        mutableStateOf(0)
    }


    NavigationBar {
        bottomNavItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(modifier = Modifier.scale(2.5f),
                selected = index == selected,
                onClick = {
                    selected = index
                    navController.navigate(bottomNavItem.route)
                },
                icon = {
                    if (index == selected) {
                        Icon(

                            painter = painterResource(id = bottomNavItem.selectedIcon),
                            contentDescription = ""
                        )
                    } else {
                        Icon(
                            painter = painterResource(id = bottomNavItem.unselectedIcon),
                            contentDescription = ""
                        )
                    }
                })

        }
    }
}