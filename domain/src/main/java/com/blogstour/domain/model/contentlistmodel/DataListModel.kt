package com.blogstour.domain.model.contentlistmodel

sealed class DataListModel() {
    data class StandartDataListModel(
        val id: Int,
        val image: ImageListModel,
        val like: Int,
        val subtitle: String? = null,
        val title: String,
        val view: Int
    ): DataListModel()

    data class RoomsDataListModel(
        val id: Int,
        val image: ImageListModel,
        val price: String,
        val title: String,
    ): DataListModel()

    data class ToursDataListModel(
        val id: Int,
        val image: ImageListModel,
        val price: String,
        val title: String,
    ): DataListModel()
}