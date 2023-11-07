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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.blogstour.app.R
import com.blogstour.app.ui.model.testModel.TestModel
import com.blogstour.app.ui.model.uimainrequestmodel.UiMainRequest
import com.blogstour.app.ui.navigation_bar.BottomNavigationBar
import com.blogstour.app.ui.screen.AppScreen
import com.blogstour.app.ui.screen.home.main_items_screen.MenuItemsScreen
import com.blogstour.app.ui.screen.home.tab_buttons.TabButtonsList
import com.blogstour.app.util.Lce

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController : NavController,
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    vm: HomeScreenViewModel = hiltViewModel()
) {
    val state by vm.state.collectAsState()
    val contents by vm.contentState.collectAsState()
    AppScreen(isDarkTheme = isDarkTheme) {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .shadow(3.dp),
                    title = {
                        Text(
                            text = stringResource(id = R.string.home),
                            style = MaterialTheme.typography.titleLarge
                        ) },
                )
            },
            bottomBar = {
                BottomNavigationBar()
            }
        ) { paddings ->
            Surface(Modifier.padding(paddings)) {
                HomeScreenContent(state = state, content = contents, navController = navController)
            }
        }
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    state: Lce<UiMainRequest>,
    navController : NavController,
    content: List<TestModel>
) {
    when (state) {
        is Lce.Content -> {
            val items = listOf(state.data)
            LazyColumn(
                modifier = modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
            )
            {
                items(items) { item ->
                    HomeItem(items = item, navController = navController, content = content)
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
            ) {
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
    items: UiMainRequest,
    content: List<TestModel>,
    navController : NavController,
) {
    Column {
        TabButtonsList(listItems = items.data.buttons)
        if (content.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(80.dp),
                    color = Color.Yellow
                )
            }
        } else {
            for (item in content) {
                MenuItemsScreen(item = item, modifier = modifier, navController = navController)
            }
        }
    }
}

