package com.blogstour.app.ui.model.uicontentlistmodel

import com.blogstour.app.ui.model.UiImageList

sealed class UiData(
    open val id: Int,
    open val image: UiImageList,
    open val subtitle: String,
    open val title: String,
) {
    data class UiStandartData(
        override val id: Int,
        override val image: UiImageList,
        override val subtitle: String,
        override val title: String,
    ): UiData(id, image, subtitle, title)

    data class UiRoomsData(
        override val id: Int,
        override val image: UiImageList,
        override val subtitle: String,
        override val title: String,
    ): UiData(id, image, subtitle, title)

    data class UiToursData(
        override val id: Int,
        override val image: UiImageList,
        override val subtitle: String,
        override val title: String,
    ): UiData(id, image, subtitle, title)
}