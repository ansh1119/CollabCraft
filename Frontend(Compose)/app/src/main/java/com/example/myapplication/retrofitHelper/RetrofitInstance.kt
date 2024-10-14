package com.example.myapplication.retrofitHelper

import TweetApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    private val BASE_URL = "https://4757-43-230-39-43.ngrok-free.app/"



    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun providesOkHttpClient(authInterceptor: AuthInterceptor): OkHttpClient{
        return OkHttpClient.Builder()  // Use OkHttpClient.Builder() correctly
            .addInterceptor(authInterceptor)  // Add the interceptor
            .build()  // Build the OkHttpClient instance
    }

    fun providesUserAPI(): TweetApi{
        return retrofit.create(TweetApi::class.java)
    }
}