package com.blogstour.data.mapper

import com.blogstour.data.model.mainrequestdto.ButtonDTO
import com.blogstour.data.model.mainrequestdto.ContentDTO
import com.blogstour.data.model.mainrequestdto.MainRequestDTO
import com.blogstour.domain.model.mainrequestmodel.ButtonModel
import com.blogstour.domain.model.mainrequestmodel.ContentModel
import com.blogstour.domain.model.mainrequestmodel.DataModel
import com.blogstour.domain.model.mainrequestmodel.MainRequestModel
import com.blogstour.domain.model.mainrequestmodel.TemplateModel
import javax.inject.Inject

class MainRequestDtoToDomainMapper @Inject constructor() {

    operator fun invoke(mainRequestDTO: MainRequestDTO) = MainRequestModel(
        data = DataModel(
            buttons = mainRequestDTO.data.buttons.map { mapButtonDtoToDomain(it) },
            content = mainRequestDTO.data.content.map { mapContentDtoToDomain(it)}
        ),
        success = mainRequestDTO.success,
        time = mainRequestDTO.time
    )


    private fun mapButtonDtoToDomain(item: ButtonDTO) = ButtonModel(
        color = item.color,
        icon = item.icon,
        title = item.title,
        type = item.type,
        url = item.url
    )

    private fun mapContentDtoToDomain(item: ContentDTO) = ContentModel(
        template = TemplateModel(
            card = item.template.card,
            direction = item.template.direction,
            type = item.template.type,
            size = item.template.size
        ),
        title = item.title,
        url = item.url
    )

}