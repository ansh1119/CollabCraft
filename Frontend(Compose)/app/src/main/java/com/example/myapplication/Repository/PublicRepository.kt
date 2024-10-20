package com.example.myapplication.Repository

import android.util.Log
import com.example.myapplication.models.User
import com.example.myapplication.service.PublicApiService
import retrofit2.Response

class PublicRepository(private val publicApiService: PublicApiService) {

    suspend fun createUser(user: User):Response<String>{
        val response=publicApiService.createUser(user)
        return response
        Log.d("CREATED",response.toString())
    }

    suspend fun login(user:User){
        val response=publicApiService.login(user)
    }

}