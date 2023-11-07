package com.blogstour.data.mapper

import com.blogstour.data.model.detailcontentdto.DetailContentDTO
import com.blogstour.domain.model.ImageListModel
import com.blogstour.domain.model.detailcontentdto.DetailContentModel
import com.blogstour.domain.model.detailcontentdto.DetailDataModel
import javax.inject.Inject

class DetailContentDtoToDomainMapper@Inject constructor() {

    operator fun invoke(data: DetailContentDTO) = DetailContentModel(
        data = DetailDataModel(
            content = data.data.content,
            date = data.data.date,
            id = data.data.id,
            image = ImageListModel(
                lg = data.data.image.lg,
                md = data.data.image.md,
                sm = data.data.image.sm,
            ),
            like = data.data.like,
            subtitle = data.data.subtitle,
            title = data.data.title,
            url = data.data.url
        ),
        error = data.error ?: "null",
        success = data.success,
        time = data.time
    )
}