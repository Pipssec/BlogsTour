package com.blogstour.app.ui.screen.home

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.blogstour.app.app.navigation.route.NoArgsRoute
import com.blogstour.app.ui.screen.main.MainNavGraph

object HomeScreenRoute : NoArgsRoute {

    override val route: String = "${MainNavGraph.ROUTE}/home"
}

fun NavGraphBuilder.homeScreenDestination(
    navController: NavHostController,
    onBack: () -> Unit,
) {
    composable(HomeScreenRoute.route) { stackEntry ->
        val vm: HomeScreenViewModel = hiltViewModel(viewModelStoreOwner = stackEntry)
        HomeScreen(
            vm = vm,
        )
    }
}