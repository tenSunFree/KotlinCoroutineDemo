package com.home.kotlincoroutinedemo.viewmodel

import androidx.lifecycle.viewModelScope
import com.home.kotlincoroutinedemo.common.BaseViewModel
import com.home.kotlincoroutinedemo.model.MainApi
import com.home.kotlincoroutinedemo.model.MainBean
import com.home.kotlincoroutinedemo.model.MainViewState
import com.home.kotlincoroutinedemo.model.provideMainApi
import kotlinx.coroutines.launch

class MainViewModel(
    private val mockApi: MainApi = provideMainApi()
) : BaseViewModel<MainViewState>() {

    fun getData() {
        viewState.value = MainViewState.Loading
        viewModelScope.launch {
            try {
                val postsResponse = mockApi.getMainPostsResponse()
                val albumsResponse = mockApi.getMainAlbumsResponse()
                val list: MutableList<MainBean> = mutableListOf()
                for (i in postsResponse.indices) {
                    val title = albumsResponse[i].title
                    val body = postsResponse[i].body
                    val bean = MainBean(title, body)
                    list.add(bean)
                }
                viewState.value = MainViewState.Success(list)
            } catch (exception: Exception) {
                viewState.value = MainViewState.Error(exception.message.toString())
            }
        }
    }
}