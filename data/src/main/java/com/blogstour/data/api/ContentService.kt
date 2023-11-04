package com.blogstour.data.api

import com.blogstour.data.model.MainRequestDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ContentService {

    @GET("main")
    suspend fun getMain(
        @Query("id") id: Int = 117
    ): Response<MainRequestDTO>
}