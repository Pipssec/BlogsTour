package com.blogstour.data.model.contentlistdto.roomsdatamodel

import com.blogstour.data.model.contentlistdto.ImageListDTO
import com.blogstour.data.model.contentlistdto.tourdatamodel.Date
import com.blogstour.data.model.contentlistdto.tourdatamodel.Duration
import com.blogstour.data.model.contentlistdto.tourdatamodel.Price

data class RoomsDataDTO(
    val countTourist: Int,
    val date: Date,
    val duration: Duration,
    val id: Int,
    val image: ImageListDTO,
    val price: Price,
    val title: String,
    val type: String
)