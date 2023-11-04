package com.blogstour.data.model.contentlistdto.roomsdatamodel

data class Price(
    val currency: String,
    val discount: Any,
    val factPrice: Int,
    val price: Int,
    val typePrice: String
)