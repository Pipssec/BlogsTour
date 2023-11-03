package com.blogstour.app.ui.screen.home

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.blogstour.app.R
import com.blogstour.app.ui.common.AppTopBar
import com.blogstour.app.ui.navigation_bar.BottomNavigation
import com.blogstour.app.ui.screen.home.main_screen.MenuItem
import com.blogstour.app.ui.screen.home.main_screen.model
import com.blogstour.app.ui.screen.home.tab_buttons.TabButtonsList
import com.blogstour.app.ui.screen.home.tab_buttons.list
import com.scumadmin.app.ui.screen.AppScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    vm: HomeScreenViewModel
) {
    val size = vm.state
    AppScreen(isDarkTheme = isDarkTheme) {
        Scaffold(
            modifier = modifier,
            topBar = {
                AppTopBar(
                    title = stringResource(R.string.home)
                )
            },
            bottomBar = {
                BottomNavigation()
            }
        ) { paddings ->
            Surface(Modifier.padding(paddings)) {
                HomeScreenContent()
            }
        }
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier
        .wrapContentHeight()
        .wrapContentWidth())
    {
        items(listOf(1)){
            HomeItem()
        }
    }
//    HomeItem()
}

@Composable
fun HomeItem(
    modifier: Modifier = Modifier
){
    Column {
        TabButtonsList(listItems = list)
        MenuItem(item = model, modifier = modifier)
    }
}

