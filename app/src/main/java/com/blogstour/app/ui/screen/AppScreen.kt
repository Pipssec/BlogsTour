package com.blogstour.app.ui.screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.blogstour.app.ui.theme.BlogsTourTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun AppScreen(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    BlogsTourTheme(darkTheme = isDarkTheme) {
        val systemUiController = rememberSystemUiController()

        SideEffect {
            systemUiController.setStatusBarColor(
                color = if (!isDarkTheme){
                    Color.Transparent
                }else Color.Black
            )
        }
        content()
    }
}