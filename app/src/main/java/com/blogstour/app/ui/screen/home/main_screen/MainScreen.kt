package com.blogstour.app.ui.screen.home.main_screen

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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.SubcomposeAsyncImage
import coil.compose.rememberAsyncImagePainter
import com.blogstour.app.ui.model.UiContent
import com.blogstour.app.ui.screen.home.main_screen.model.uiblog.Date
import com.blogstour.app.ui.screen.home.main_screen.model.uiblog.ImageUrl
import com.blogstour.app.ui.screen.home.main_screen.model.uiblog.UiBlogContent


@Composable
fun MenuItemsScreen(
    modifier: Modifier = Modifier,
    item: UiContent
) {
    Column(
        modifier = modifier
            .wrapContentSize(unbounded = true)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            text = item.title,
            style = MaterialTheme.typography.labelLarge
        )
        GridList(listBlog = listBlogs, modifier = modifier)

//        LazyVerticalGrid(
//            modifier = Modifier
//                .wrapContentSize(unbounded = true),
//            columns = GridCells.Fixed(2)
//        ) {
//            items(listBlogs) { item ->
//                ContentItem(item = item)
//            }
//        }
    }
}

@Composable
fun GridList(
    modifier: Modifier = Modifier,
    listBlog: List<UiBlogContent>
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
                ContentItem(item = listBlog[count])
            }
            return
        }
        Row(
            modifier = modifier
                .fillMaxSize(),
            verticalAlignment = CenterVertically,
        ) {
            ContentItem(item = listBlog[count])
            ContentItem(item = listBlog[count + 1])
            count += 2
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ContentItem(
    modifier: Modifier = Modifier,
    item: UiBlogContent
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        val painter =
            rememberAsyncImagePainter(model = "https://cdn2.rsttur.ru/photos/blog-220-360-240-80.webp?v=1647165731")
        SubcomposeAsyncImage(
            modifier = modifier
                .width(180.dp),
            model = item.imageUrl.lg,
            loading = {
                CircularProgressIndicator()
            },
            contentDescription = null
        )
        Text(
            modifier = modifier,
            text = item.title,
            fontSize = 10.sp
        )
        Text(
            modifier = modifier
                .width(180.dp),
            textAlign = TextAlign.Justify,
            text = item.subtitle,
            fontSize = 10.sp
        )
    }
}

//@Preview
//@Composable
//private fun MenuItemPreview() {
//    BlogsTourTheme {
//        MenuItem(
//            item = model
//        )
//    }
//}
//
//val model = UiContent(
//    title = "Блог",
//    url = "url",
//    template = UiTemplate()
//)

val listBlogs = listOf(
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