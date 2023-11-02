package com.blogstour.app.app.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry

interface Route<T> {
    val route: String
    val arguments: List<NamedNavArgument>
    fun prepareRoute(arg: T): String
    fun getArgs(navBackStackEntry: NavBackStackEntry): T
}