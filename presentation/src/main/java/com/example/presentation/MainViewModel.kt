package com.example.presentation

import androidx.core.os.trace
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entity.uistate.MainUiState
import com.example.interactor.Navigator
import com.example.interactor.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val navigator: Navigator,
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Init)
    val uiState = _uiState.asStateFlow()

    fun onDownloadClick() {
        viewModelScope.launch {
            trace("MainViewModel.onDownloadClick") {
                println("download started")
                _uiState.tryEmit(MainUiState.Loading)
                val result = getNewsUseCase()
                println("download finished")
                //Timber.d(result.toString())
                _uiState.tryEmit(MainUiState.Init)
            }
        }
    }
}