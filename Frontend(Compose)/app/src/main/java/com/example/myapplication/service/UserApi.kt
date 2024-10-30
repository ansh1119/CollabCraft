package com.example.myapplication.service

import com.example.myapplication.models.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApi {

    @GET("/user/get-user/{username}")
    suspend fun getUser(
        @Path("username") username:String,
    ): Response<User>

    @GET("/tweets/get-applicants/{id}")
    suspend fun getApplicants(
        @Path("id") id:String,
    ):Response<List<User>>
}