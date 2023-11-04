package com.blogstour.data.model.contentlistdto.tourdatamodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ToursContentListDTO(
    @SerializedName("data")
    val data: List<ToursDataDTO>,
    @SerializedName("error")
    val error: Any,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("time")
    val time: String
): Serializable