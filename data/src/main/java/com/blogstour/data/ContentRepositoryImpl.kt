package com.blogstour.data

import com.blogstour.data.api.ContentService
import com.blogstour.data.mapper.MainRequestDtoToDomainMapper
import com.blogstour.data.model.MainRequestDTO
import com.blogstour.domain.ContentRepository
import com.blogstour.domain.model.MainRequestModel
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

class ContentRepositoryImpl@Inject constructor(
    private val contentService: ContentService,
    private val mapper: MainRequestDtoToDomainMapper
): ContentRepository {
    override suspend fun getMainContent(): Response<MainRequestModel> {
        val result = contentService.getMain()
        val resultConvert = mapDtoToDomain(result)
        return resultConvert
    }

    private fun mapDtoToDomain(result: Response<MainRequestDTO>): Response<MainRequestModel> {
        return if (result.isSuccessful) {
            Response.success(result.body()?.let { mapper(it) })
        } else {
            Response.error(result.code(), result.errorBody() ?: result.message().toResponseBody())
        }
    }
}