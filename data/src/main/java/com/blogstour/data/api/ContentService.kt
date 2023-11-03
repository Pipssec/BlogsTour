package com.blogstour.data.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ContentService {

    @GET("main")
    suspend fun getMain(
        @Query("id") id: String
    )
}