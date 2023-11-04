package com.blogstour.domain

import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.mainrequestmodel.MainRequestModel
import retrofit2.Response

interface ContentRepository {
    suspend fun getMainContent(): Response<MainRequestModel>

    suspend fun getListStandartContent(url: String): Response<ContentListModel>
    suspend fun getListRoomsContent(url: String): Response<ContentListModel>
    suspend fun getListToursContent(url: String): Response<ContentListModel>
}