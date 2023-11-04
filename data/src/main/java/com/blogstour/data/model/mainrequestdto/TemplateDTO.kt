package com.blogstour.data.model.mainrequestdto

import com.google.gson.annotations.SerializedName

data class TemplateDTO(
    @SerializedName("card")
    val card: String,
    @SerializedName("direction")
    val direction: String,
    @SerializedName("object")
    val type: String,
    @SerializedName("size")
    val size: String
)