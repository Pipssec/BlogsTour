package com.blogstour.data.model.contentlistdto.tourdatamodel

import com.blogstour.data.model.ImageListDTO

data class Home(
    val base: Base,
    val id: Int,
    val image: ImageListDTO,
    val name: String,
    val night: Int,
    val type: String,
    val url: String
)