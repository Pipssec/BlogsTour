package com.blogstour.data.mapper

import com.blogstour.data.model.contentlistdto.tourdatamodel.ToursContentListDTO
import com.blogstour.data.model.contentlistdto.tourdatamodel.ToursDataDTO
import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.contentlistmodel.DataListModel
import com.blogstour.domain.model.ImageListModel
import javax.inject.Inject

class ToursContentListDtoToDomainMapper @Inject constructor() {

    operator fun invoke(dto: ToursContentListDTO) = ContentListModel(
        data = dto.data.map { mapToursDataDtoToDomain(it) },
        success = dto.success,
        time = dto.time
    )

    private fun mapToursDataDtoToDomain(data: ToursDataDTO) =
        DataListModel.ToursDataListModel(
            id = data.id,
            image = ImageListModel(
                lg = data.image.lg,
                md = data.image.md,
                sm = data.image.sm
            ),
            title = data.title,
            price = "${data.price.price} ${data.price.currency}"
        )

}