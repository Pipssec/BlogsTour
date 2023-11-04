package com.blogstour.app.util.mapper

import com.blogstour.app.ui.model.uicontentlist.UiContentList
import com.blogstour.app.ui.model.uicontentlist.UiDataList
import com.blogstour.app.ui.model.uicontentlist.UiImageList
import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.contentlistmodel.DataListModel
import javax.inject.Inject

class ContentListDomainToUiMapper @Inject constructor() {

    operator fun invoke(dto: ContentListModel) = UiContentList(
        data = dto.data.map { isType(it) },
        success = dto.success,
        time = dto.time
    )

    private fun isType(data: DataListModel): UiDataList {
        return when (data) {
            is DataListModel.StandartDataListModel -> mapStandartDataDomainToModel(data)
            is DataListModel.RoomsDataListModel -> mapRoomsDataDomainToModel(data)
            is DataListModel.ToursDataListModel -> mapToursDataDomainToModel(data)
        }
    }

    private fun mapStandartDataDomainToModel(data: DataListModel.StandartDataListModel) =
        UiDataList.UiStandartDataList(
            id = data.id,
            image = UiImageList(
                lg = data.image.lg,
                md = data.image.md,
                sm = data.image.sm
            ),
            subtitle = data.subtitle ?: "subtitle",
            title = data.title,
        )

    private fun mapToursDataDomainToModel(data: DataListModel.ToursDataListModel ) =
        UiDataList.UiToursDataList(
            id = data.id,
            image = UiImageList(
                lg = data.image.lg,
                md = data.image.md,
                sm = data.image.sm
            ),
            title = data.title,
            subtitle = data.price
        )

    private fun mapRoomsDataDomainToModel(data: DataListModel.RoomsDataListModel) =
        UiDataList.UiRoomsDataList(
            id = data.id,
            image = UiImageList(
                lg = data.image.lg,
                md = data.image.md,
                sm = data.image.sm
            ),
            title = data.title,
            subtitle = data.price
        )

}