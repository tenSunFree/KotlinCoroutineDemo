package com.home.kotlincoroutinedemo.model

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MainApi {

    @GET("posts")
    suspend fun getMainPostsResponse(): MainPostsResponse

    @GET("albums")
    suspend fun getMainAlbumsResponse(): MainAlbumsResponse
}

fun provideMainApi(): MainApi {
    val okHttpClient = OkHttpClient.Builder().build()
    val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(MainApi::class.java)
}