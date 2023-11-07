package com.blogstour.app.ui.screen.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blogstour.app.ui.model.detailscontentmodel.UiDetailContent
import com.blogstour.app.util.AppException
import com.blogstour.app.util.Lce
import com.blogstour.app.util.mapper.DetailContentDomainToUiMapper
import com.blogstour.domain.usecase.GetDetailContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val detailContentUseCase: GetDetailContentUseCase,
    private val mapper: DetailContentDomainToUiMapper
) : ViewModel() {

    private val _state = MutableStateFlow<Lce<UiDetailContent>>(Lce.Loading)
    val state = _state.asStateFlow()

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            viewModelScope.launch {
                handleError(throwable)
            }

        }
    private suspend fun handleError(error: Throwable) {
        _state.emit(Lce.Error(AppException.NetworkException(error.toString())))
    }

    fun getContent(id: Int) = viewModelScope.launch(coroutineExceptionHandler + Dispatchers.IO) {

        _state.value = Lce.Loading

        val result = detailContentUseCase.getDetailContent(id)

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