package com.blogstour.domain

import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.mainrequestmodel.MainRequestModel
import retrofit2.Response

interface ContentRepository {
    suspend fun getMainContent(): Response<MainRequestModel>

    suspend fun getListContent(url: String): Response<ContentListModel>
}