package com.blogstour.domain.model.detailcontentdto

data class DetailContentModel(
    val data: DetailDataModel,
    val error: String,
    val success: Boolean,
    val time: String
)