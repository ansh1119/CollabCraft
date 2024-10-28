//package com.example.myapplication.service
//
//import TweetApiService
//import android.util.Log
//import androidx.lifecycle.viewModelScope
//import com.example.myapplication.models.Tweet
//import com.example.myapplication.models.User
//import kotlinx.coroutines.launch
//import retrofit2.HttpException
//import retrofit2.Response
//
//class TweetApiServiceImpl:TweetApiService {
//    override suspend fun getTweets(): List<Tweet> {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun createUser(user: User): Response<String> {
//        viewModelScope.launch {
//            try {
//                val response:String = repository.createUser(user).toString()
//                Log.d("SUCCESSFUL",response.toString())
//            } catch (e: HttpException) {
//                Log.w("HTTP EXCEPTION",e.toString())
//            } catch (e: Exception) {
//                Log.w("MAJOR ERROR",e.toString())
//            }
//        }
//    }
//}