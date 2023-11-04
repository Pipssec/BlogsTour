package com.blogstour.app.ui.navigation_bar

import com.blogstour.app.R
import com.blogstour.app.app.navigation.Routes


sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home :
        BottomNavItem(
            Routes.HOME,
            "Главная",
            R.drawable.home
        )

    object Map :
        BottomNavItem(
            Routes.MAP,
            "Карта",
            R.drawable.map_search_outline
        )

    object Reservation :
        BottomNavItem(
            Routes.RESERVATION,
            "Бронь",
            R.drawable.shopping_outline
        )

    object Chat :
        BottomNavItem(
            Routes.CHAT,
            "Чат",
            R.drawable.comments
        )

    object Settings :
        BottomNavItem(
            Routes.SETTINGS,
            "Еще",
            R.drawable.dots_horizontal
        )
}