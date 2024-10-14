package com.example.myapplication.retrofitHelper

import TweetApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://4757-43-230-39-43.ngrok-free.app/"




    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: TweetApi by lazy {
        retrofit.create(TweetApi::class.java)
    }
}