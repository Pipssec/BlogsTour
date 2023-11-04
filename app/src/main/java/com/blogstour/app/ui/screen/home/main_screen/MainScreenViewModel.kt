package com.blogstour.app.ui.screen.home.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blogstour.app.ui.model.uicontentlist.UiContentList
import com.blogstour.app.util.AppException
import com.blogstour.app.util.Lce
import com.blogstour.app.util.mapper.ContentListDomainToUiMapper
import com.blogstour.domain.usecase.GetListContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getContentList: GetListContentUseCase,
    private val mapper: ContentListDomainToUiMapper
) : ViewModel() {

    private val _state = MutableStateFlow<Lce<UiContentList>>(Lce.Loading)
    val state = _state.asStateFlow()


    fun getContent(url: String) = viewModelScope.launch(Dispatchers.IO) {

        _state.value = Lce.Loading

        val result = getContentList.getListContent(url)

        val body = result.body()
        if (result.isSuccessful && body != null) {
            val resultRequest = mapper(body)
            _state.value = Lce.Content(resultRequest)
        } else {
            _state.value = Lce.Error(
                AppException.NetworkException(result.errorBody().toString())
            )
        }
    }
}
