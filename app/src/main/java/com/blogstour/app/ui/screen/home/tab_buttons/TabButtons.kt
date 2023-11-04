package com.blogstour.app.ui.screen.home.tab_buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blogstour.app.R
import com.blogstour.app.ui.model.uimainrequest.UiButton
import com.blogstour.app.ui.screen.home.tab_buttons.model.UiTabButton
import com.blogstour.app.ui.theme.BlogsTourTheme
import com.blogstour.app.ui.theme.g11
import com.blogstour.app.ui.theme.g12
import com.blogstour.app.ui.theme.g13
import com.blogstour.app.ui.theme.g19

@Composable
fun TabButtonsList(
    modifier: Modifier = Modifier,
    listItems: List<UiButton>
) {
//    ScrollableTabRow(selectedTabIndex = 0) {
//        for (item in list){
//            TabButtonItem(item = item)
//        }
//    }
    LazyRow(
        modifier = modifier
            .wrapContentWidth()
            .wrapContentHeight(),
        contentPadding = PaddingValues( horizontal = 8.dp)
    ) {
        items(listItems){ item ->
            TabButtonItem(item = item)
        }
    }
}

@Composable
fun TabButtonItem(
    modifier: Modifier = Modifier,
    item: UiButton
) {
    TextButton(
        modifier = modifier
            .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 16.dp)
            .wrapContentWidth()
            .height(40.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 12.dp
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = setBackgroundColor(item.color)
        ),
        onClick = { }
    ) {
        Row(
            modifier = modifier.wrapContentWidth()
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(setIcon(item.icon)),
                contentDescription = null,
                tint = Color.White
            )
            Text(
                modifier = modifier.padding(start = 8.dp),
                text = item.title,
                style = MaterialTheme.typography.labelLarge,
                color = Color.White
            )
        }
    }
}

fun setIcon(icon: String): Int {
    return when (icon) {
        "rst-weather-cloudy" -> R.drawable.weather_sunny
        "rst-help" -> R.drawable.help_circle_outline
        "rst-play-circle" -> R.drawable.baseline_play_circle_24
        "rst-map_marker_path" -> R.drawable.map_marker_path
        else -> R.drawable.baseline_error_24
    }
}

fun setBackgroundColor(color: String): Color {
    return when (color) {
        "g-13" -> g13
        "g-12" -> g12
        "g-11" -> g11
        "g-19" -> g19
        else -> Color.Red
    }
}

@Preview
@Composable
private fun TabButtonPreview(){
    BlogsTourTheme {
        TabButtonItem(
            item = UiButton(
                color = "g-13",
                icon = "rst-weather-cloudy",
                title = "+5°C",
                type = "type",
                url = "url"
            )
        )
    }
}

//@Preview
//@Composable
//private fun TabButtonListPreview(){
//    BlogsTourTheme {
//        TabButtonsList(
//            listItems = list
//        )
//    }
//}

val list = listOf(
    UiTabButton(
        color = "g-13",
        icon = "rst-weather-cloudy",
        title = "+5°C",
        type = "type",
        url = "url"
    ),
    UiTabButton(
        color = "g-11",
        icon = "rst-map_marker_path",
        title = "Как добраться?",
        type = "type",
        url = "url"
    ),
    UiTabButton(
        color = "g-12",
        icon = "rst-help",
        title = "О базе отдыха",
        type = "type",
        url = "url"
    ),
    UiTabButton(
        color = "g-19",
        icon = "rst-play-circle",
        title = "3d тур",
        type = "type",
        url = "url"
    )
)