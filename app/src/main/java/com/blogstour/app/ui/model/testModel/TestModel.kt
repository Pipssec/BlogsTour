package com.blogstour.app.ui.model.testModel

import com.blogstour.app.ui.model.uicontentlistmodel.UiData

data class TestModel(
    val name: String,
    val content: List<UiData?>,
    val type: String
) {
}