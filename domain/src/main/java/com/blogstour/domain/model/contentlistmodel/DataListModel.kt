package com.blogstour.domain.model.contentlistmodel

data class DataListModel(
    val date: DateListModel,
    val id: Int,
    val image: ImageListModel,
    val like: Int,
    val subtitle: String,
    val title: String,
    val view: Int
)