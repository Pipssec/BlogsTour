package com.blogstour.app.app.navigation.route

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.blogstour.app.app.navigation.Route

interface NoArgsRoute : Route<Unit> {

    override val arguments: List<NamedNavArgument> get() = emptyList()

    override fun prepareRoute(arg: Unit): String = route

    override fun getArgs(navBackStackEntry: NavBackStackEntry): Nothing {
        throw IllegalArgumentException("This is route without arguments!")
    }
}