package com.blogstour.app.util

/**sealed class to handle different state of getting data (LCE - loading, content, error)*/
sealed class Lce<out T> {
    object Loading : Lce<Nothing>()
    data class Content<T>(val data: T) : Lce<T>()
    data class Error(val exception: AppException) : Lce<Nothing>()
}