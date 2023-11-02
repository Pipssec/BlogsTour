package com.blogstour.app.app.navigation

abstract class NavGraph<Args, StartRoute : Route<Args>>(
    val route: String,
    val startRoute: StartRoute
) {

    fun prepareRoute(arg: Args): String = startRoute.prepareRoute(arg)
}