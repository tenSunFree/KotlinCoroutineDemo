package com.home.kotlincoroutinedemo.model

class MainPostsResponse : ArrayList<MainPostsResponse.MainPostsResponseItem>() {
    data class MainPostsResponseItem(
        val userId: Int,
        val id: Int,
        val title: String,
        val body: String
    )
}