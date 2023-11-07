package com.blogstour.domain.model.detailcontentdto

import com.blogstour.domain.model.ImageListModel

data class DetailDataModel(
    val content: String,
    val date: String,
    val id: Int,
    val image: ImageListModel,
    val like: Int,
    val subtitle: String,
    val title: String,
    val url: String
)