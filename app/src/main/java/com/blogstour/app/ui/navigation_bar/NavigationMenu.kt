package com.blogstour.app.ui.navigation_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun BottomNavigation() {

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Map,
        BottomNavItem.Reservation,
        BottomNavItem.Chat,
        BottomNavItem.Settings,
    )

    NavigationBar(
        modifier = Modifier.background(Color.White)
    ) {
        items.forEach { item ->
            AddItem(
                screen = item
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
) {

    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                painterResource(id = screen.icon),
                contentDescription = screen.title
            )
        },
        selected = false,
        alwaysShowLabel = true,
        onClick = { /*TODO*/ },
        colors = NavigationBarItemDefaults.colors()
    )
}