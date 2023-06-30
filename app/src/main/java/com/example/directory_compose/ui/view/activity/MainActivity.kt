package com.example.directory_compose.ui.view.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.directory_compose.ui.view.page.HomePage
import com.example.directory_compose.ui.view.page.UserDetailPage
import com.example.directory_compose.ui.view.page.UserSavePage
import com.example.directory_compose.model.User
import com.example.directory_compose.ui.theme.DirectoryComposeTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DirectoryComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PageNavigation()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DirectoryComposeTheme {

    }
}

@Composable
fun PageNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home_age") {
        composable("home_age") {
            HomePage(navController = navController)
        }
        composable("save_page") {
            UserSavePage()
        }
        composable("detail_page/{user}", arguments = listOf(
            navArgument("user") { type = NavType.StringType}
        )) {
            val json = it.arguments?.getString("user")
            val user = Gson().fromJson(json, User::class.java)
            UserDetailPage(user = user)
        }
    }
}