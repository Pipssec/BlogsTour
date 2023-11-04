package com.blogstour.data.api

import com.blogstour.data.model.contentlistdto.ContentListDTO
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
    suspend fun getContent(
        @Url url: String
    ): Response<ContentListDTO>

}