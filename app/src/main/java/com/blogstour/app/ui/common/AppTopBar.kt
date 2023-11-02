package com.blogstour.app.ui.common

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blogstour.app.ui.theme.BlogsTourTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(title: String){
    return TopAppBar(
        modifier = Modifier
            .shadow(3.dp),
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            ) },
    )
}

@Composable
fun RefreshAction(
    modifier: Modifier = Modifier,
    refreshListItem: ()-> Unit,
){
    IconButton(
        modifier = modifier
            .width(48.dp)
            .height(48.dp),
        onClick = refreshListItem
    ) {
        Icon(
            imageVector = Icons.Filled.Refresh,
            contentDescription = ""
        )
    }
}

@Preview
@Composable
private fun RefreshActionPreview(){
    BlogsTourTheme {
        RefreshAction(refreshListItem = { /*TODO*/ } )
    }
}
