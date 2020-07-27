package com.home.kotlincoroutinedemo.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T> : ViewModel() {

    protected val viewState: MutableLiveData<T> = MutableLiveData()

    fun getViewState(): LiveData<T> = viewState
}