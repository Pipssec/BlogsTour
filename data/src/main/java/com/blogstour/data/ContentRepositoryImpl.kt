package com.blogstour.data

import com.blogstour.domain.ContentRepository
import com.blogstour.domain.model.MainRequestModel
import javax.inject.Inject

class ContentRepositoryImpl@Inject constructor(): ContentRepository {
    override suspend fun getMainContent(): MainRequestModel {
        TODO("Not yet implemented")
    }
}