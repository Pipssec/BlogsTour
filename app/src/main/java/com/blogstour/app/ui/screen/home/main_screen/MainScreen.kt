package com.blogstour.app.ui.screen.home.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blogstour.app.R
import com.blogstour.app.ui.screen.home.main_screen.model.uiblog.Date
import com.blogstour.app.ui.screen.home.main_screen.model.uiblog.ImageUrl
import com.blogstour.app.ui.screen.home.main_screen.model.uiblog.UiBlogContent
import com.blogstour.app.ui.screen.home.main_screen.model.uimenu.Template
import com.blogstour.app.ui.screen.home.main_screen.model.uimenu.UiMenuContent
import com.blogstour.app.ui.theme.BlogsTourTheme


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column() {

    }
}

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    item: UiMenuContent
) {
    Column() {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            text = item.title,
            style = MaterialTheme.typography.labelLarge
        )
        LazyVerticalGrid(
            modifier = modifier,
            columns = GridCells.Fixed(2)
        ) {
            items(list) { item ->
                ContentItem(item = item)
            }
        }
    }
}

@Composable
fun ContentItem(
    modifier: Modifier = Modifier,
    item: UiBlogContent
) {
    Column(modifier = modifier
        .padding(top = 8.dp)
    ) {
        Icon(
            modifier = modifier,
            painter = painterResource(id = R.drawable.weather_sunny),
            tint = Color.Black,
            contentDescription = null )
        Text(
            modifier = modifier,
            text = item.title,
            fontSize = 10.sp
        )
        Text(
            modifier = modifier,
            text = item.subtitle,
            fontSize = 10.sp
        )
    }
}

@Preview
@Composable
private fun MenuItemPreview() {
    BlogsTourTheme {
        MenuItem(
            item = model
        )
    }
}

val model = UiMenuContent(
    title = "Блог",
    url = "url",
    template = Template()
)

val list = listOf(
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    ),
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    ),
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    ),
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    ),
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    ),
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    ),
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    ),
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    ),
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    ),
    UiBlogContent(
        date = Date(),
        imageUrl = ImageUrl()
    )
)