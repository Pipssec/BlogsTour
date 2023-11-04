package com.blogstour.domain.model.mainrequestmodel

data class MainRequestModel(
    val data: DataModel,
    val success: Boolean,
    val time: String
)