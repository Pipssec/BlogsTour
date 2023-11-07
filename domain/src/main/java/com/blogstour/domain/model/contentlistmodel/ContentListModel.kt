package com.blogstour.domain.model.contentlistmodel

data class ContentListModel(
    val data: List<DataListModel>,
    val success: Boolean,
    val time: String
)