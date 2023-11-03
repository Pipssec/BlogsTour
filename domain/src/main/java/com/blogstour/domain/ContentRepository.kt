package com.blogstour.domain

import com.blogstour.domain.model.MainRequestModel

interface ContentRepository {
    suspend fun getMainContent(): MainRequestModel
}