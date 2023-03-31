package com.example.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entity.common.TraceSection
import com.example.entity.uistate.MainUiState
import com.example.interactor.Navigator
import com.example.interactor.usecase.GetNewsUseCase
import com.example.traceutil.traceAsync
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

    fun onDownloadClick() = viewModelScope.launch {

        traceAsync(TraceSection.MAIN_VM_ON_CLICK.traceName) {
            _uiState.tryEmit(MainUiState.Loading)
            getNewsUseCase()
            _uiState.tryEmit(MainUiState.Init)
        }
    }
}