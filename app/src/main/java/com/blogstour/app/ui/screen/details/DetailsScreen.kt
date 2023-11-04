package com.blogstour.app.ui.screen.details

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.blogstour.app.R
import com.blogstour.app.ui.common.AppTopBar
import com.blogstour.app.ui.screen.AppScreen


@Composable
fun DetailsScreen(
    id: String,
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
){
    AppScreen(isDarkTheme = isDarkTheme) {
        Scaffold(
            modifier = modifier,
            topBar = {
                AppTopBar(
                    title = stringResource(R.string.home)
                )
            },
        ) { paddings ->
            Surface(Modifier.padding(paddings)) {
                DetailsScreenContent()
            }
        }
    }
}

@Composable
fun DetailsScreenContent(
    modifier: Modifier = Modifier
){

}