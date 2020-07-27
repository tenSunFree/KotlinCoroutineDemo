package com.home.kotlincoroutinedemo.model

class MainAlbumsResponse : ArrayList<MainAlbumsResponse.MainAlbumsResponseItem>() {
    data class MainAlbumsResponseItem(
        val userId: Int,
        val id: Int,
        val title: String
    )
}