package com.blogstour.data

import com.blogstour.data.api.ContentService
import com.blogstour.data.mapper.MainRequestDtoToDomainMapper
import com.blogstour.data.mapper.RoomsContentListDtoToDomainMapper
import com.blogstour.data.mapper.StandartContentListDtoToDomainMapper
import com.blogstour.data.mapper.ToursContentListDtoToDomainMapper
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
    private val mapperStandartContentList: StandartContentListDtoToDomainMapper,
    private val mapperRoomsContentList: RoomsContentListDtoToDomainMapper,
    private val mapperToursContentList: ToursContentListDtoToDomainMapper,
    ): ContentRepository {
    override suspend fun getMainContent(): Response<MainRequestModel> {
        val result = contentService.getMain()
        return mapperDtoToDomain(result){mapperMainRequest(it)}
    }

    override suspend fun getListStandartContent(url: String): Response<ContentListModel> {
        val result = contentService.getStandartContent(url)
        return mapperDtoToDomain(result) { mapperStandartContentList(it) }
    }

    override suspend fun getListRoomsContent(url: String): Response<ContentListModel> {
        val result = contentService.getRoomsContent(url)
        return mapperDtoToDomain(result) { mapperRoomsContentList(it) }
    }

    override suspend fun getListToursContent(url: String): Response<ContentListModel> {
        val result = contentService.getToursContent(url)
        return mapperDtoToDomain(result) { mapperToursContentList(it) }
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