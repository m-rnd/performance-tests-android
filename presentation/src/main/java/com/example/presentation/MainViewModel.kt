package com.example.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interactor.Navigator
import com.example.interactor.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val navigator: Navigator,
    getNewsUseCase: GetNewsUseCase
): ViewModel()
{
    init {
        viewModelScope.launch {
            getNewsUseCase()
            println("init MainViewModel")
        }
    }
}