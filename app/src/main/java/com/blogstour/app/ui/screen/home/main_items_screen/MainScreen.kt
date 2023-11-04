package com.blogstour.app.ui.screen.home.main_items_screen

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
import coil.compose.SubcomposeAsyncImage
import com.blogstour.app.ui.model.testModel.TestModel
import com.blogstour.app.ui.model.uicontentlist.UiDataList


@Composable
fun MenuItemsScreen(
    modifier: Modifier = Modifier,
    item: TestModel,
) {
    Column(
        modifier = modifier
            .wrapContentSize(unbounded = true)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
            text = item.name,
            fontSize = 24.sp,
            style = MaterialTheme.typography.labelLarge
        )
        GridList(listBlog = item.content, modifier = modifier)
    }
}

@Composable
fun GridList(
    modifier: Modifier = Modifier,
    listBlog: List<UiDataList?>
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
                listBlog[count]?.let { ContentItem(item = it) }
            }
            return
        }
        Row(
            modifier = modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.Top,
        ) {
            listBlog[count]?.let { ContentItem(item = it) }
            listBlog[count + 1]?.let { ContentItem(item = it) }
            count += 2
        }
    }
}

@Composable
fun ContentItem(
    modifier: Modifier = Modifier,
    item: UiDataList
) {
    Column {
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
                model = item.image.lg,
                loading = {
                    CircularProgressIndicator()
                },
                contentDescription = null
            )
        }
        Text(
            modifier = modifier
                .width(180.dp),
            textAlign = TextAlign.Justify,
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

