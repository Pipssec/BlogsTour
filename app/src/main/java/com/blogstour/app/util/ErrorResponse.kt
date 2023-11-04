package com.blogstour.app.util

/**
 * Class for showing error from retrofit
 * @param status - error  name
 * @param error - error code*/
data class ErrorResponse(
    val status: String = "",
    val error: String = ""
)
