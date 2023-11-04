package com.blogstour.domain.usecase

import com.blogstour.domain.ContentRepository
import com.blogstour.domain.model.mainrequestmodel.MainRequestModel
import retrofit2.Response
import javax.inject.Inject

class GetMainContentUseCase @Inject constructor(
    private val contentRepository: ContentRepository
) {
    suspend fun getMainContent(): Response<MainRequestModel> {
        return contentRepository.getMainContent()
    }
}