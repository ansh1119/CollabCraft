package com.example.myapplication.components

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.models.BottomNavItem
import com.example.myapplication.retrofitHelper.TokenManager

@Composable
fun BottomNav(navController: NavController) {
    val context: Context = LocalContext.current
    val tokenManager = remember { TokenManager(context) }
    val username = tokenManager.getUsername() ?: "login" // Fallback

    val bottomNavItems = listOf(
        BottomNavItem(route = "homescreen", selectedIcon = R.drawable.homeon, unselectedIcon = R.drawable.home),
        BottomNavItem(route = "create", selectedIcon = R.drawable.addon, unselectedIcon = R.drawable.add),
        BottomNavItem(route = "profile/$username", selectedIcon = R.drawable.useron, unselectedIcon = R.drawable.maleuser)
    )

    var selected by remember { mutableStateOf(0) }

    NavigationBar {
        bottomNavItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                modifier = Modifier.scale(2.5f),
                selected = index == selected,
                onClick = {
                    selected = index
                    navController.navigate(bottomNavItem.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    val icon = if (index == selected) bottomNavItem.selectedIcon else bottomNavItem.unselectedIcon
                    Icon(painter = painterResource(id = icon), contentDescription = null)
                }
            )
        }
    }
}
