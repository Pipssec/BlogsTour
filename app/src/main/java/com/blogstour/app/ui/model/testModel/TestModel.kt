package com.blogstour.app.ui.model.testModel

import com.blogstour.app.ui.model.uicontentlist.UiDataList

data class TestModel(
    val name: String,
    val content: List<UiDataList?>,
    val type: String
) {
}