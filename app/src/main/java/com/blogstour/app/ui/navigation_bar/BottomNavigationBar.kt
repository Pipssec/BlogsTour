package com.blogstour.app.ui.navigation_bar

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Map,
        BottomNavItem.Reservation,
        BottomNavItem.Chat,
        BottomNavItem.Settings,
    )

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background
    ) {
        items.forEach { item ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(),
                label = { Text(text = item.title, fontSize = 12.sp) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp),
                        contentDescription = item.title
                    )
                },
                alwaysShowLabel = true,
                selected = false,
                onClick = {},
            )
        }
    }
}