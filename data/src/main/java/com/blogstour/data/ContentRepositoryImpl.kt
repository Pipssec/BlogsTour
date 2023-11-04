package com.blogstour.data

import com.blogstour.data.api.ContentService
import com.blogstour.data.mapper.ContentListDtoToDomainMapper
import com.blogstour.data.mapper.MainRequestDtoToDomainMapper
import com.blogstour.data.model.mainrequestdto.MainRequestDTO
import com.blogstour.domain.ContentRepository
import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.mainrequestmodel.MainRequestModel
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import javax.inject.Inject

class ContentRepositoryImpl@Inject constructor(
    private val contentService: ContentService,
    private val mapperMainRequest: MainRequestDtoToDomainMapper,
    private val mapperContentList: ContentListDtoToDomainMapper
): ContentRepository {
    override suspend fun getMainContent(): Response<MainRequestModel> {
        val result = contentService.getMain()
        return mapperDtoToDomain(result){mapperMainRequest(it)}
    }

    override suspend fun getListContent(url: String): Response<ContentListModel> {
        val result = contentService.getContent(url)
        return mapperDtoToDomain(result) { mapperContentList(it) }
    }

    private fun mapMainRequestDtoToDomain(result: Response<MainRequestDTO>): Response<MainRequestModel> {
        return if (result.isSuccessful) {
            Response.success(result.body()?.let { mapperMainRequest(it) })
        } else {
            Response.error(result.code(), result.errorBody() ?: result.message().toResponseBody())
        }
    }

    private inline fun <T, E> mapperDtoToDomain(result: Response<T>, mapper: (T)->E): Response<E> {
        return if (result.isSuccessful) {
            Response.success(result.body()?.let { mapper(it) })
        } else {
            Response.error(result.code(), result.errorBody() ?: result.message().toResponseBody())
        }
    }
}