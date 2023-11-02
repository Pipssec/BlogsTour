package com.scumadmin.app.ui.screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.blogstour.app.ui.theme.BlogsTourTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppScreen(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    isNavigationBarTransparent: Boolean = false,
    content: @Composable () -> Unit
) {
    BlogsTourTheme(darkTheme = isDarkTheme) {
        val systemUiController = rememberSystemUiController()
        val navigationBarColor = if (!isNavigationBarTransparent) {
            MaterialTheme.colorScheme.surface
        } else {
            Color.Transparent
        }

        SideEffect {
            systemUiController.setNavigationBarColor(
                color = navigationBarColor,
                darkIcons = !isDarkTheme
            )
            systemUiController.setStatusBarColor(
                color = Color.Transparent,
                darkIcons = !isDarkTheme
            )
        }
        content()
    }
}