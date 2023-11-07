package com.blogstour.data.mapper

import com.blogstour.data.model.contentlistdto.roomsdatamodel.RoomsContentListDTO
import com.blogstour.data.model.contentlistdto.roomsdatamodel.RoomsDataDTO
import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.contentlistmodel.DataListModel
import com.blogstour.domain.model.ImageListModel
import javax.inject.Inject

class RoomsContentListDtoToDomainMapper @Inject constructor() {

    operator fun invoke(dto: RoomsContentListDTO) = ContentListModel(
        data = dto.data.map { mapRoomsDataDtoToDomain(it) },
        success = dto.success,
        time = dto.time
    )

    private fun mapRoomsDataDtoToDomain(data: RoomsDataDTO) =
        DataListModel.RoomsDataListModel(
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