package com.blogstour.app.ui.screen.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.blogstour.app.ui.theme.BlogsTourTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BlogsTourTheme {
                val navController = rememberNavController()
                val onBackClicked = {
                    if (!navController.popBackStack()) {
                        finish()
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = MainNavGraph.ROUTE,
                ) {
                    mainNavGraph(
                        navController = navController,
                        onBack = onBackClicked,
                    )
                }

            }
        }
    }
}
