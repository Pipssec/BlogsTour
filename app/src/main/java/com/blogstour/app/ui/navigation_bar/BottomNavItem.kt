package com.blogstour.app.ui.navigation_bar

import com.blogstour.app.R


sealed class BottomNavItem(
    var title: String,
    var icon: Int
) {
    object Home :
        BottomNavItem(
            "Главная",
            R.drawable.home
        )

    object Map :
        BottomNavItem(
            "Карта",
            R.drawable.map_search_outline
        )

    object Reservation :
        BottomNavItem(
            "Бронь",
            R.drawable.shopping_outline
        )

    object Chat :
        BottomNavItem(
            "Чат",
            R.drawable.comments
        )

    object Settings :
        BottomNavItem(
            "Еще",
            R.drawable.dots_horizontal
        )
}