package com.blogstour.app.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blogstour.app.ui.model.uimainrequest.UiMainRequest
import com.blogstour.app.util.AppException
import com.blogstour.app.util.Lce
import com.blogstour.app.util.mapper.MainRequestDomainToUiMapper
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
    private val mapper: MainRequestDomainToUiMapper
) : ViewModel() {


    private val _state =  MutableStateFlow<Lce<UiMainRequest>>(Lce.Loading)
    val state = _state.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {

            _state.value = Lce.Loading

            val result = getMainContent.getMainContent()

            val body = result.body()
            if (result.isSuccessful && body != null) {
                val resultRequest = mapper(body)
                _state.value = Lce.Content(resultRequest)
            } else {
                _state.value = Lce.Error(
                    AppException.NetworkException(result.errorBody().toString()))
            }
        }
    }
}