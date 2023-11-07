package com.blogstour.app.ui.screen.details

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.SubcomposeAsyncImage
import com.blogstour.app.R
import com.blogstour.app.ui.model.detailscontentmodel.UiDetailContent
import com.blogstour.app.ui.model.detailscontentmodel.UiDetailData
import com.blogstour.app.ui.screen.AppScreen
import com.blogstour.app.util.Lce
import java.util.Locale


@Composable
fun DetailsScreen(
    id: Int,
    modifier: Modifier = Modifier,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    navController: NavController,
    vm: DetailsScreenViewModel = hiltViewModel()
) {
    vm.getContent(id)
    AppScreen(isDarkTheme = isDarkTheme) {
        Scaffold(
            modifier = modifier,
        ) { paddings ->
            Surface(Modifier.padding(paddings)) {
                DetailsScreenContent(navController = navController, vm = vm)
            }
        }
    }

}

@Composable
fun DetailsScreenContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: DetailsScreenViewModel
) {
    val state by vm.state.collectAsState()
    when (state) {
        is Lce.Content -> {
            val item = (state as Lce.Content<UiDetailContent>).data
            DetailsScreenContentItem(
                navController = navController,
                item = item.data,
                modifier = modifier
            )
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
                    modifier = Modifier.size(40.dp),
                    color = Color.Yellow
                )
            }
        }
    }
}

@Composable
fun DetailsScreenContentItem(
    modifier: Modifier = Modifier,
    navController: NavController,
    item: UiDetailData
) {
    Column(
        modifier = modifier
            .verticalScroll(ScrollState(1))
            .fillMaxWidth()
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
        ) {
            SubcomposeAsyncImage(
                modifier = modifier
                    .fillMaxSize(),
                model = item.image.lg,
                contentDescription = null,
            )
            Icon(
                modifier = modifier
                    .padding(start = 20.dp, top = 44.dp)
                    .width(40.dp)
                    .height(40.dp)
                    .clickable { navController.popBackStack() },
                imageVector = ImageVector.vectorResource(id = R.drawable.baseline_arrow_circle_left_24),
                tint = Color.White,
                contentDescription = null
            )

        }
        Text(
            modifier = modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp),
            text = getFormattedDate(item.date),
            fontSize = 12.sp

        )
        Text(
            modifier = modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Start,
            text = item.title,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            modifier = modifier
                .padding(all = 16.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Justify,
            text = item.content
        )
    }

}

fun getFormattedDate(
    dateString: String?,
    patternInput: String = "yyyy-MM-dd'T'HH:mm:ss",
    patternOutput: String = "dd.MM.yyyy"
): String {
    val inputFormat = java.text.SimpleDateFormat(patternInput, Locale.getDefault())
    val outputFormat = java.text.SimpleDateFormat(patternOutput, Locale.getDefault())
    return try {
        val date = inputFormat.parse(dateString)
        outputFormat.format(date)
    } catch (e: Exception) {
        "Empty"
    }
}

