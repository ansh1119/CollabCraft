package com.example.myapplication.retrofitHelper

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor:Interceptor {

    var tokenManager: TokenManager= TokenManager(this)

    override fun intercept(chain: Interceptor.Chain): Response {
        val request=chain.request().newBuilder()
        val token=tokenManager.getToken()
        if (token != null) {
            request.addHeader("Authorization","Bearer $token")
        }
        return chain.proceed(request.build())
    }
}