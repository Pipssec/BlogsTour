package com.blogstour.app.ui.model.uicontentlist

sealed class UiDataList(
    open val id: Int,
    open val image: UiImageList,
    open val subtitle: String,
    open val title: String,
) {
    data class UiStandartDataList(
        override val id: Int,
        override val image: UiImageList,
        override val subtitle: String,
        override val title: String,
    ): UiDataList(id, image, subtitle, title)

    data class UiRoomsDataList(
        override val id: Int,
        override val image: UiImageList,
        override val subtitle: String,
        override val title: String,
    ): UiDataList(id, image, subtitle, title)

    data class UiToursDataList(
        override val id: Int,
        override val image: UiImageList,
        override val subtitle: String,
        override val title: String,
    ): UiDataList(id, image, subtitle, title)
}