package com.blogstour.app.util.mapper

import com.blogstour.app.ui.model.UiImageList
import com.blogstour.app.ui.model.detailscontentmodel.UiDetailContent
import com.blogstour.app.ui.model.detailscontentmodel.UiDetailData
import com.blogstour.domain.model.detailcontentdto.DetailContentModel
import javax.inject.Inject

class DetailContentDomainToUiMapper@Inject constructor() {

    operator fun invoke(data: DetailContentModel) = UiDetailContent(
        data = UiDetailData(
            content = data.data.content,
            date = data.data.date,
            id = data.data.id,
            image = UiImageList(
                lg = data.data.image.lg,
                md = data.data.image.md,
                sm = data.data.image.sm,
            ),
            like = data.data.like,
            subtitle = data.data.subtitle,
            title = data.data.title,
            url = data.data.url
        ),
        error = data.error,
        success = data.success,
        time = data.time
    )
}