package com.blogstour.domain.usecase

import com.blogstour.domain.model.detailcontentdto.DetailContentModel
import com.blogstour.domain.ContentRepository
import retrofit2.Response
import javax.inject.Inject

class GetDetailContentUseCase@Inject constructor(
    private val repository: ContentRepository
) {
    suspend fun getDetailContent(id: Int): Response<DetailContentModel>{
       return repository.getDetailContent(id)
    }
}