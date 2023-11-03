package com.blogstour.domain.model

data class MainRequestModel(
    val data: DataModel,
    val error: Any,
    val success: Boolean,
    val time: String
)