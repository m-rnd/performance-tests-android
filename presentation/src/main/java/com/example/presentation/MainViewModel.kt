package com.example.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interactor.Navigator
import com.example.interactor.usecase.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val navigator: Navigator,
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {
    init {
        println("init MainViewModel")
    }


    fun onDownloadClick() {
        viewModelScope.launch {
            println("download started")
            getNewsUseCase()
            //Timber.d(getNewsUseCase().toString())
            println("download finished")
        }
    }
}