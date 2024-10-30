package com.example.myapplication.retrofitHelper

import TweetApi
import android.content.Context
import com.example.myapplication.models.User
import com.example.myapplication.service.PublicApiService
import com.example.myapplication.service.UserApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance(private val token: String? = null) {

    private val BASE_URL = "https://76cd-2401-4900-1c3c-3c62-60e0-f7fd-a209-52cd.ngrok-free.app/"


    val gson = GsonBuilder()
        .setLenient()
        .create()

    // Provide public Retrofit instance (without AuthInterceptor)
    fun providesPublicRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
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

    fun providesUserAPI(context: Context): UserApi {
        return providesAuthRetrofit(context).create(UserApi::class.java)
    }
}