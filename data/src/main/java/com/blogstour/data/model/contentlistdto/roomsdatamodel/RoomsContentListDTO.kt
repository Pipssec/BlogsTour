package com.blogstour.data.model.contentlistdto.roomsdatamodel

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RoomsContentListDTO(
    @SerializedName("data")
    val data: List<RoomsDataDTO>,
    @SerializedName("error")
    val error: Any,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("time")
    val time: String
): Serializable