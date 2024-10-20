package com.example.myapplication.service

import com.example.myapplication.models.Tweet
import com.example.myapplication.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PublicApiService {
    @POST("/public/create-user")
    suspend fun createUser(@Body user:User):Response<String>

    @POST("/public/login")
    suspend fun login(@Body user:User):Response<String>


}