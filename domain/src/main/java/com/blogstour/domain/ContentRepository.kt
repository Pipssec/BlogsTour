package com.blogstour.domain

import com.blogstour.domain.model.MainRequestModel
import retrofit2.Response

interface ContentRepository {
    suspend fun getMainContent(): Response<MainRequestModel>
}