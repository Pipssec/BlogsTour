package com.blogstour.app.ui.model.detailscontentmodel

import com.blogstour.app.ui.model.UiImageList

data class UiDetailData(
    val content: String,
    val date: String,
    val id: Int,
    val image: UiImageList,
    val like: Int,
    val subtitle: String,
    val title: String,
    val url: String
)