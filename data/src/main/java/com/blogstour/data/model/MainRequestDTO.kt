package com.blogstour.data.model

import java.io.Serializable

data class MainRequestDTO(
    val data: DataDTO,
    val error: Any,
    val success: Boolean,
    val time: String
): Serializable