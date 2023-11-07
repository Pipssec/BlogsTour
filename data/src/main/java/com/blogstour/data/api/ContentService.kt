package com.blogstour.data.api

import com.blogstour.data.model.contentlistdto.roomsdatamodel.RoomsContentListDTO
import com.blogstour.data.model.contentlistdto.standartdatadto.StandartContentListDTO
import com.blogstour.data.model.contentlistdto.tourdatamodel.ToursContentListDTO
import com.blogstour.data.model.detailcontentdto.DetailContentDTO
import com.blogstour.data.model.mainrequestdto.MainRequestDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ContentService {

    @GET("main")
    suspend fun getMain(
        @Query("id") id: Int = 117
    ): Response<MainRequestDTO>

    @GET
    suspend fun getStandartContent(
        @Url url: String
    ): Response<StandartContentListDTO>

    @GET
    suspend fun getRoomsContent(
        @Url url: String
    ): Response<RoomsContentListDTO>

    @GET
    suspend fun getToursContent(
        @Url url: String
    ): Response<ToursContentListDTO>

    @GET("blog-info")
    suspend fun getBlogInfo(
        @Query("id") id: Int = 117,
        @Query("blog_id") blogId: Int,
    ): Response<DetailContentDTO>

}