package com.blogstour.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MainRequestDTO(
    @SerializedName("data")
    val data: DataDTO,
    @SerializedName("error")
    val error: Any,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("time")
    val time: String
): Serializable