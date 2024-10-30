import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.retrofitHelper.TokenManager
import com.example.myapplication.screens.ApplicantsListScreen
import com.example.myapplication.screens.HomeScreen
import com.example.myapplication.screens.LoginScreen
import com.example.myapplication.screens.ProfileScreen
import com.example.myapplication.screens.SignUp2

@Composable
fun App() {
    val navController = rememberNavController()

    val context = LocalContext.current
    val tokenManager = remember { TokenManager(context) }

    // JWT token check in LaunchedEffect to avoid re-composition issues
    LaunchedEffect(Unit) {
        val jwtToken = tokenManager.getToken()
        if (jwtToken != null) {
            navController.navigate("homescreen") {
                popUpTo("login") { inclusive = true } // Clear login from backstack
            }
        }
    }

    NavHost(navController = navController, startDestination = "login") {
        composable(route = "sign-up") {
            SignUp(navController)
        }
        composable(
            route = "sign-up-2/{username}/{password}",
            arguments = listOf(
                navArgument("username") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) {
            val username = it.arguments?.getString("username")
            val password = it.arguments?.getString("password")
            if (username != null && password != null) {
                SignUp2(navController, username, password)
            }
        }
        composable(route = "homescreen") {
            HomeScreen(navController)
        }
        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "profile/{username}",
            arguments = listOf(
                navArgument("username") { type = NavType.StringType },
            )
        ) {
            val username=it.arguments?.getString("username")
            if(username!=null) {
                ProfileScreen(navController,username)
            }
        }

        composable(route = "applicants/{id}",
            arguments = listOf(
                navArgument("id"){type= NavType.StringType}
            )
        ) {
            val id= it.arguments?.getString("id")
            ApplicantsListScreen(navController, id.toString())
        }
    }
}
