package com.example.myapplication.retrofitHelper

import TweetApi
import android.content.Context
import com.example.myapplication.service.PublicApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance(private val token: String? = null) {

    private val BASE_URL = "https://dc17-103-72-7-27.ngrok-free.app/"

    // Provide public Retrofit instance (without AuthInterceptor)
    fun providesPublicRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Provide Retrofit instance with authentication, if token exists
    private fun providesAuthInterceptor(context: Context): AuthInterceptor {
        return AuthInterceptor(token ?: "", context)
    }

    private fun providesOkHttpClient(context: Context): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()

        // Only add the AuthInterceptor if a token is provided
        token?.let {
            okHttpBuilder.addInterceptor(providesAuthInterceptor(context))
        }

        return okHttpBuilder.build()
    }

    // Retrofit instance with OkHttpClient (used for authenticated requests)
    fun providesAuthRetrofit(context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(providesOkHttpClient(context))
            .build()
    }

    // Public API service (no authentication required)
    fun providesPublicApiService(): PublicApiService {
        return providesPublicRetrofit().create(PublicApiService::class.java)
    }

    // Authenticated API service (requires authentication)
    fun providesTweetAPI(context: Context): TweetApi {
        return providesAuthRetrofit(context).create(TweetApi::class.java)
    }
}