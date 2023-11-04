package com.blogstour.data.mapper

import com.blogstour.data.model.contentlistdto.ContentListDTO
import com.blogstour.data.model.contentlistdto.DataListDTO
import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.contentlistmodel.DataListModel
import com.blogstour.domain.model.contentlistmodel.DateListModel
import com.blogstour.domain.model.contentlistmodel.ImageListModel
import javax.inject.Inject

class ContentListDtoToDomainMapper @Inject constructor() {

    operator fun invoke(dto: ContentListDTO) = ContentListModel(
        data = dto.data.map{mapDataDtoToDomain(it)},
        success = dto.success,
        time = dto.time
    )

    private fun mapDataDtoToDomain(data: DataListDTO) = DataListModel(
        date = DateListModel(
            data.date.date,
            data.date.typeDate
        ),
        id = data.id,
        image = ImageListModel(
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