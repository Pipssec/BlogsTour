package com.blogstour.app.util.mapper

import com.blogstour.app.ui.model.uimainrequestmodel.UiButton
import com.blogstour.app.ui.model.uimainrequestmodel.UiContent
import com.blogstour.app.ui.model.uimainrequestmodel.UiData
import com.blogstour.app.ui.model.uimainrequestmodel.UiMainRequest
import com.blogstour.app.ui.model.uimainrequestmodel.UiTemplate
import com.blogstour.domain.model.mainrequestmodel.ButtonModel
import com.blogstour.domain.model.mainrequestmodel.ContentModel
import com.blogstour.domain.model.mainrequestmodel.MainRequestModel
import javax.inject.Inject

class MainRequestDomainToUiMapper @Inject constructor() {

    operator fun invoke(mainRequestModel: MainRequestModel) = UiMainRequest(
        data = UiData(
            buttons = mainRequestModel.data.buttons.map { mapButtonDomainToUi(it) },
            content = mainRequestModel.data.content.map { mapContentDomainToUi(it)}
        ),
        success = mainRequestModel.success,
        time = mainRequestModel.time
    )

    private fun mapButtonDomainToUi(item: ButtonModel) = UiButton(
        color = item.color,
        icon = item.icon,
        title = item.title,
        type = item.type,
        url = item.url
    )

    private fun mapContentDomainToUi(item: ContentModel) = UiContent(
        template = UiTemplate(
            card = item.template.card,
            direction = item.template.direction,
            type = item.template.type,
            size = item.template.size
        ),
        title = item.title,
        url = item.url
    )

}