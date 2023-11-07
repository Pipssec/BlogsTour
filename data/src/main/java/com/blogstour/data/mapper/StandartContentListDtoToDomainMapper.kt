package com.blogstour.data.mapper

import com.blogstour.data.model.contentlistdto.standartdatadto.StandartContentListDTO
import com.blogstour.data.model.contentlistdto.standartdatadto.StandartDataDTO
import com.blogstour.domain.model.contentlistmodel.ContentListModel
import com.blogstour.domain.model.contentlistmodel.DataListModel
import com.blogstour.domain.model.ImageListModel
import javax.inject.Inject

class StandartContentListDtoToDomainMapper @Inject constructor() {

    operator fun invoke(dto: StandartContentListDTO) = ContentListModel(
        data = dto.data.map { mapStandartDataDtoToDomain(it) },
        success = dto.success,
        time = dto.time
    )

//    private fun isType(data: StandartDataDTO): DataListModel {
//        return when (data) {
//            is StandartDataDTO.StandartDataDTO -> mapStandartDataDtoToDomain(data)
//            is StandartDataDTO.RoomsDataDTO -> mapRoomsDataDtoToDomain(data)
//            is StandartDataDTO.ToursDataDTO -> mapToursDataDtoToDomain(data)
//        }
//    }

    private fun mapStandartDataDtoToDomain(data: StandartDataDTO) =
        DataListModel.StandartDataListModel(
            id = data.id,
            image = ImageListModel(
                lg = data.image.lg,
                md = data.image.md,
                sm = data.image.sm
            ),
            like = data.like,
            subtitle = data.subtitle,
            title = data.title,
            view = data.view
        )

//    private fun mapToursDataDtoToDomain(data: StandartDataDTO.ToursDataDTO) =
//        DataListModel.ToursDataListModel(
//            id = data.id,
//            image = ImageListModel(
//                lg = data.image.lg,
//                md = data.image.md,
//                sm = data.image.sm
//            ),
//            title = data.title,
//            price = "${data.price.price} ${data.price.currency}"
//        )
//
//    private fun mapRoomsDataDtoToDomain(data: StandartDataDTO.RoomsDataDTO) =
//        DataListModel.RoomsDataListModel(
//            id = data.id,
//            image = ImageListModel(
//                lg = data.image.lg,
//                md = data.image.md,
//                sm = data.image.sm
//            ),
//            title = data.title,
//            price = "${data.price.price} ${data.price.currency}"
//        )

}