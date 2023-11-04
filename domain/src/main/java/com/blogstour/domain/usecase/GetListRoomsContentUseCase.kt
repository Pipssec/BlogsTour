package com.blogstour.domain.usecase

import com.blogstour.domain.ContentRepository
import com.blogstour.domain.model.contentlistmodel.ContentListModel
import retrofit2.Response
import javax.inject.Inject

class GetListRoomsContentUseCase@Inject constructor(
    private val contentRepository: ContentRepository
) {
    suspend fun getListContent(url: String): Response<ContentListModel>{
        return contentRepository.getListStandartContent(url)
    }
}