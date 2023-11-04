package com.blogstour.data.model.contentlistdto

data class DataListDTO(
    val date: DateListDTO,
    val id: Int,
    val image: ImageListDTO,
    val like: Int,
    val subtitle: String,
    val title: String,
    val view: Int
)