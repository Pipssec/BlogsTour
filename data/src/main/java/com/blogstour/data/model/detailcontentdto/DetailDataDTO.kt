package com.blogstour.data.model.detailcontentdto

import com.blogstour.data.model.ImageListDTO

data class DetailDataDTO(
    val content: String,
    val date: String,
    val id: Int,
    val image: ImageListDTO,
    val like: Int,
    val subtitle: String,
    val title: String,
    val url: String
)