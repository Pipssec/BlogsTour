package com.blogstour.data.model.contentlistdto.standartdatadto

import com.blogstour.data.model.contentlistdto.ImageListDTO

data class StandartDataDTO(
    val id: Int,
    val image: ImageListDTO,
    val like: Int,
    val subtitle: String,
    val title: String,
    val view: Int
)
