package com.blogstour.app.ui.screen.home.main_screen.model.uiblog

data class UiBlogContent(
    val date: Date,
    val id: Int = 233,
    val imageUrl: ImageUrl,
    val like: Int = 6,
    val subtitle: String = "Отдых в Приморье осенью. Погода в осенние месяцы, виды развлчений, туры и базы отдыха.",
    val title: String = "Чем заняться в Приморье осенью",
    val view: Int = 869
)