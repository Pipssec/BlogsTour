package com.blogstour.data.model.contentlistdto

data class ContentListDTO(
    val data: List<DataListDTO>,
    val error: Any,
    val success: Boolean,
    val time: String
)