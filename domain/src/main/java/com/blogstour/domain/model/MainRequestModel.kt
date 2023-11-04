package com.blogstour.domain.model

data class MainRequestModel(
    val data: DataModel,
    val success: Boolean,
    val time: String
)