package com.blogstour.app.ui.screen.main

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.blogstour.app.app.navigation.NavGraph
import com.blogstour.app.ui.screen.home.HomeScreenRoute
import com.blogstour.app.ui.screen.home.homeScreenDestination

class MainNavGraph : NavGraph<Unit, HomeScreenRoute>(
    route = ROUTE,
    startRoute = HomeScreenRoute
) {
    companion object {
        const val ROUTE = "main"
    }
}

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    onBack: () -> Unit,
) {
    val mainNavGraph = MainNavGraph()
    navigation(
        startDestination = mainNavGraph.startRoute.route,
        route = mainNavGraph.route
    ) {
        homeScreenDestination(navController, onBack)
    }
}