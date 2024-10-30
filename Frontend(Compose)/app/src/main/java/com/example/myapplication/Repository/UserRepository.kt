package com.example.myapplication.Repository

import android.util.Log
import com.example.myapplication.models.TweetResponse
import com.example.myapplication.models.User
import com.example.myapplication.service.UserApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserRepository(private val userApi:UserApi) {

    private val _applicants= MutableStateFlow<List<User>>(emptyList())
    val applicants: StateFlow<List<User>> get()=_applicants

    suspend fun getUser(username:String): User {
        val response=userApi.getUser(username)
        Log.d("Repo","RPOSITORY CALL")
        return response.body()!!
    }

    suspend fun getApplicants(id:String){
        val response=userApi.getApplicants(id)
        if(response.isSuccessful && response.body()!=null){
            _applicants.emit(response.body()!!)
        }
    }
}