package com.home.kotlincoroutinedemo.model

sealed class MainViewState {
    object Loading : MainViewState()
    data class Success(val list: MutableList<MainBean>) : MainViewState()
    data class Error(val message: String) : MainViewState()
}