package com.blogstour.app.ui.screen.home.main_items_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.blogstour.app.ui.model.testModel.TestModel
import com.blogstour.app.ui.model.uicontentlistmodel.UiData
import com.blogstour.app.util.NavDestinations


@Composable
fun MenuItemsScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    item: TestModel,
) {
    Column(
        modifier = modifier
            .wrapContentSize(unbounded = true)
    ) {
        Text(
            modifier = Modifier.padding(all = 8.dp),
            text = item.name,
            fontSize = 24.sp,
            style = MaterialTheme.typography.labelLarge
        )
        GridList(
            listBlog = item.content,
            modifier = modifier,
            navController = navController,
            type = item.type
        )
    }
}

@Composable
fun GridList(
    modifier: Modifier = Modifier,
    navController: NavController,
    listBlog: List<UiData?>,
    type: String
) {
    var count = 0
    for (i in listBlog) {
        if (count == listBlog.size) {
            return
        }
        if (count + 1 == listBlog.size) {
            Row(
                modifier = modifier
                    .fillMaxSize(),
                verticalAlignment = CenterVertically,
            ) {
                listBlog[count]?.let {
                    ContentItem(
                        item = it,
                        navController = navController,
                        type = type
                    )
                }
            }
            return
        }
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            listBlog[count]?.let {
                ContentItem(
                    item = it,
                    navController = navController,
                    type = type
                )
            }
            listBlog[count + 1]?.let {
                ContentItem(
                    item = it,
                    navController = navController,
                    type = type
                )
            }
            count += 2
        }
    }
}

@Composable
fun ContentItem(
    modifier: Modifier = Modifier,
    navController: NavController,
    item: UiData,
    type: String
) {
    Column(
        modifier = modifier
            .clickable {
                if (type == "blog") {
                    navController.navigate("${NavDestinations.DETAIL_SCREEN}/${item.id}")
                } else { }
            }
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(all = 8.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            SubcomposeAsyncImage(
                modifier = modifier
                    .width(180.dp),
                model = item.image.md,
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = null
            )
        }
        Text(
            modifier = modifier
                .padding(start = 8.dp, end = 4.dp)
                .width(180.dp),
            textAlign = TextAlign.Justify,
            text = item.title,
            fontSize = 16.sp
        )
        Text(
            modifier = modifier
                .padding(start = 8.dp, end = 4.dp)
                .width(180.dp),
            textAlign = TextAlign.Justify,
            text = item.subtitle,
            fontSize = 14.sp,
        )
    }
}

