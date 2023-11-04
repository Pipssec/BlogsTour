package com.blogstour.app.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.blogstour.app.R
import com.blogstour.app.ui.common.AppTopBar
import com.blogstour.app.ui.model.UiMainRequest
import com.blogstour.app.ui.navigation_bar.BottomNavigation
import com.blogstour.app.ui.screen.home.main_screen.MenuItemsScreen
import com.blogstour.app.ui.screen.home.tab_buttons.TabButtonsList
import com.blogstour.app.util.Lce
import com.scumadmin.app.ui.screen.AppScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    vm: HomeScreenViewModel = hiltViewModel()
) {
    val state = vm.state.collectAsState()
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
                HomeScreenContent(state = state)
            }
        }
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    state: State<Lce<UiMainRequest>>
) {
    when (state.value) {
        is Lce.Content -> {
            val items = listOf((state.value as Lce.Content<UiMainRequest>).data)
            LazyColumn(modifier = modifier
                .wrapContentHeight()
                .wrapContentWidth())
            {
                items(items){ item ->
                        HomeItem(item = item)
                }
            }
        }

        is Lce.Error -> {
            val context = LocalContext.current
            Toast.makeText(
                context, "Error", Toast.LENGTH_SHORT
            ).show()
        }

        is Lce.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    modifier = Modifier.size(80.dp),
                    color = Color.Yellow
                )
            }
        }
    }
//    HomeItem()
}

@Composable
fun HomeItem(
    modifier: Modifier = Modifier,
    item: UiMainRequest
){
    val listUiContents = item.data.content
    Column {
        TabButtonsList(listItems = item.data.buttons)
        for (i in listUiContents){
            MenuItemsScreen(item = i, modifier = modifier)
        }

    }
}

