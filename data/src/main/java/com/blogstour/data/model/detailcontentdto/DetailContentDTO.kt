package com.blogstour.data.model.detailcontentdto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DetailContentDTO(
    @SerializedName("data")
    val data: DetailDataDTO,
    @SerializedName("error")
    val error: String?,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("time")
    val time: String
): Serializable