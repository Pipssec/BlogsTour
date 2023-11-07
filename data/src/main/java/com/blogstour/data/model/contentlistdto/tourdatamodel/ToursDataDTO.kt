package com.blogstour.data.model.contentlistdto.tourdatamodel

import com.blogstour.data.model.ImageListDTO


data class ToursDataDTO(
    val date: Date,
    val duration: Duration,
    val home: Home,
    val id: Int,
    val image: ImageListDTO,
    val location: String,
    val price: Price,
    val title: String,
    val url: String
)