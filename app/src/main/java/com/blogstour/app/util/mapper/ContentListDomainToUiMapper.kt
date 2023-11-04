package com.blogstour.app.util.mapper

import com.blogstour.app.ui.model.uicontentlist.UiContentList
import com.blogstour.app.ui.model.uicontentlist.UiDataList
import com.blogstour.app.ui.model.uicontentlist.UiDateList
import com.blogstour.app.ui.model.uicontentlist.UiImageList
import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.contentlistmodel.DataListModel
import javax.inject.Inject

class ContentListDomainToUiMapper @Inject constructor() {

    operator fun invoke(domain: ContentListModel) = UiContentList(
        data = domain.data.map{mapDataDomainToUi(it)},
        success = domain.success,
        time = domain.time
    )

    private fun mapDataDomainToUi(data: DataListModel) = UiDataList(
        date = UiDateList(
            data.date.date,
            data.date.typeDate
        ),
        id = data.id,
        image = UiImageList(
            data.image.lg,
            data.image.md,
            data.image.sm
        ),
        like = data.like,
        subtitle = data.subtitle,
        title = data.title,
        view = data.view
        )

}