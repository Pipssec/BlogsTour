package com.blogstour.app.util.mapper

import com.blogstour.app.ui.model.uicontentlistmodel.UiContentList
import com.blogstour.app.ui.model.uicontentlistmodel.UiData
import com.blogstour.app.ui.model.UiImageList
import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.contentlistmodel.DataListModel
import javax.inject.Inject

class ContentListDomainToUiMapper @Inject constructor() {

    operator fun invoke(dto: ContentListModel) = UiContentList(
        data = dto.data.map { isType(it) },
        success = dto.success,
        time = dto.time
    )

    private fun isType(data: DataListModel): UiData {
        return when (data) {
            is DataListModel.StandartDataListModel -> mapStandartDataDomainToModel(data)
            is DataListModel.RoomsDataListModel -> mapRoomsDataDomainToModel(data)
            is DataListModel.ToursDataListModel -> mapToursDataDomainToModel(data)
        }
    }

    private fun mapStandartDataDomainToModel(data: DataListModel.StandartDataListModel) =
        UiData.UiStandartData(
            id = data.id,
            image = UiImageList(
                lg = data.image.lg,
                md = data.image.md,
                sm = data.image.sm
            ),
            subtitle = data.subtitle ?: "",
            title = data.title,
        )

    private fun mapToursDataDomainToModel(data: DataListModel.ToursDataListModel ) =
        UiData.UiToursData(
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
        UiData.UiRoomsData(
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