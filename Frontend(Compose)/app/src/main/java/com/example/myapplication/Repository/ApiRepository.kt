package com.example.myapplication.Repository

import TweetApi
import androidx.lifecycle.LiveData
import com.example.myapplication.models.Tweet
import com.example.myapplication.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response

class ApiRepository(private val tweetApi: TweetApi) {

    private val _tweets= MutableStateFlow<List<Tweet>>(emptyList())
    val tweets:StateFlow<List<Tweet>> get()=_tweets

    suspend fun getTweets(){
        val response=tweetApi.getTweets()
        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }


//
    suspend fun createUser(user:User): Response<String> {
        return tweetApi.createUser(user)
    }
}