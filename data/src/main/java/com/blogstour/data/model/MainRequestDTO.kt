package com.blogstour.data.model

data class MainRequestDTO(
    val data: DataDTO,
    val error: Any,
    val success: Boolean,
    val time: String
)