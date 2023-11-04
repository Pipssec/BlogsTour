package com.blogstour.app.ui.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blogstour.app.ui.model.testModel.TestModel
import com.blogstour.app.ui.model.uimainrequest.UiContent
import com.blogstour.app.ui.model.uimainrequest.UiMainRequest
import com.blogstour.app.util.AppException
import com.blogstour.app.util.Lce
import com.blogstour.app.util.mapper.ContentListDomainToUiMapper
import com.blogstour.app.util.mapper.MainRequestDomainToUiMapper
import com.blogstour.domain.usecase.GetListRoomsContentUseCase
import com.blogstour.domain.usecase.GetListStandartContentUseCase
import com.blogstour.domain.usecase.GetListToursContentUseCase
import com.blogstour.domain.usecase.GetMainContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getMainContent: GetMainContentUseCase,
    private val mapperMainRequest: MainRequestDomainToUiMapper,
    private val getStandartContentList: GetListStandartContentUseCase,
    private val getToursContentList: GetListToursContentUseCase,
    private val getRoomsContentList: GetListRoomsContentUseCase,
    private val mapperContentList: ContentListDomainToUiMapper
) : ViewModel() {


    private val _state = MutableStateFlow<Lce<UiMainRequest>>(Lce.Loading)
    val state = _state.asStateFlow()

    private val _contentState = MutableStateFlow<List<TestModel>>(emptyList())
    val contentState = _contentState.asStateFlow()

    private var _listMenuItems = ArrayList<TestModel>()
    private var listContents: List<UiContent> = mutableListOf()


    init {
        viewModelScope.launch(Dispatchers.IO) {

            _state.value = Lce.Loading

            val result = getMainContent.getMainContent()

            val body = result.body()
            if (result.isSuccessful && body != null) {
                val resultRequest = mapperMainRequest(body)
                listContents = resultRequest.data.content
                _state.value = Lce.Content(resultRequest)
            } else {
                _state.value = Lce.Error(
                    AppException.NetworkException(result.errorBody().toString())
                )
            }
            for (item in listContents) {
                val resultContent = when (item.template.type) {
                    "room" -> getRoomsContentList.getListContent(item.url).body()
                        ?.let { mapperContentList(it) }

                    "tour" -> getToursContentList.getListContent(item.url).body()
                        ?.let { mapperContentList(it) }

                    else -> getStandartContentList.getListContent(item.url).body()
                        ?.let { mapperContentList(it) }
                }

                if (resultContent != null) {
                    _listMenuItems.add(
                        TestModel(
                            name = item.title,
                            content = resultContent.data,
                            type = item.template.type
                        )
                    )
                }
                if (item == listContents[listContents.size - 1]) {
                    _contentState.emit(_listMenuItems)
                    Log.d("viewmodel", _listMenuItems.size.toString())
                }
            }
        }
    }
}