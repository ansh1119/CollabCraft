package com.example.myapplication.Repository

import android.util.Log
import android.widget.Toast
import com.example.myapplication.models.LoginRequest
import com.example.myapplication.models.User
import com.example.myapplication.service.PublicApiService
import retrofit2.Response

class PublicRepository(private val publicApiService: PublicApiService) {

    suspend fun createUser(user: User): String? {
        val response=publicApiService.createUser(user)
        return response.body()
        Log.d("CREATED",response.toString())
    }

    suspend fun login(loginRequest: LoginRequest): String? {
        val response = publicApiService.login(loginRequest)
        if (response.isSuccessful) {
            Log.d("LOGIN SUCCESS",response.body().toString())
            return response.body()// Token returned by the server
        } else {
            Log.d("LOGIN ERROR",response.body().toString())
            return null// Handle login failure
        }
    }

}