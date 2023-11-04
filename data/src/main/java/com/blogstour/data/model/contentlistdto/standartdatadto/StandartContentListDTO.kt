package com.blogstour.data.model.contentlistdto.standartdatadto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StandartContentListDTO(
    @SerializedName("data")
    val data: List<StandartDataDTO>,
    @SerializedName("error")
    val error: Any,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("time")
    val time: String
): Serializable