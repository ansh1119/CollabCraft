package com.example.myapplication.retrofitHelper

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response


class AuthInterceptor(private val token: String, context:Context) : Interceptor {

    var tokenManager: TokenManager= TokenManager(context)


    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        val token=tokenManager.getToken()
        request.addHeader("Authorization","Bearer $token")

        return chain.proceed(request.build())
    }
}
