package com.example.myapplication


import SignUp
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.screens.HomeScreen
import com.example.myapplication.screens.LoginScreen
import com.example.myapplication.screens.SignUp2

@Composable
fun App() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login"){
        composable(route="sign-up") {
            SignUp(navController)
        }
        composable(route="sign-up-2/{username}/{password}",
            arguments = listOf(
            navArgument("username"){
                type=NavType.StringType
            },
            navArgument("password"){
                type=NavType.StringType
            }
        )) {
            val username = it.arguments?.getString("username")
            val password = it.arguments?.getString("password")
            if (password != null && username!=null) {
                SignUp2(navController,username,password)
            }
        }

        composable(route="homescreen") {
            HomeScreen(navController)
        }

        composable(route="login") {
            LoginScreen(navController)
        }
    }
}