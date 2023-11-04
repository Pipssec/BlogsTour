package com.blogstour.app.ui.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.blogstour.app.ui.screen.home.HomeScreen
import com.blogstour.app.ui.theme.BlogsTourTheme
import com.blogstour.app.util.NavDestinations
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogsTourTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = NavDestinations.MAIN_SCREEN,
                ) {
                    composable(NavDestinations.MAIN_SCREEN) {
                        HomeScreen(navController = navController)
                    }
                    composable("${NavDestinations.DETAIL_SCREEN}/{newsId}") {
//                        it.arguments?.getString("newsId")?.toInt()?.let { newsId ->
//                            DetailScreen(newsId, navController)
                    }
                }

            }
        }
    }
}

