package com.example.entity.uistate

sealed class MainUiState {
    object Init: MainUiState()
    object Loading: MainUiState()
}