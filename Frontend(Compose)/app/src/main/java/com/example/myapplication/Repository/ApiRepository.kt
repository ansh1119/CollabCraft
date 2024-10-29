package com.example.myapplication.Repository

import TweetApi
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.myapplication.models.Tweet
import com.example.myapplication.models.TweetResponse
import com.example.myapplication.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response

class ApiRepository(private val tweetApi: TweetApi) {

    private val _tweets= MutableStateFlow<List<TweetResponse>>(emptyList())
    val tweets:StateFlow<List<TweetResponse>> get()=_tweets

    private val _tweetsByDomain= MutableStateFlow<List<TweetResponse>>(emptyList())
    val tweetsByDomain:StateFlow<List<TweetResponse>> get()=_tweetsByDomain

    suspend fun getTweets(){
        val response=tweetApi.getTweets()
        if(response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }

    suspend fun application(objectId:String){
        val response=tweetApi.apply(objectId)
        if(response.isSuccessful && response.body()!=null){
            Log.d("APPLICATION","APPLIED SUCCESSFULLY")
        }
    }

    suspend fun getTweetsByDomain(domain:String){
        val response=tweetApi.getTweetsByDomain(domain)
        if(response.isSuccessful && response.body()!=null){
            _tweetsByDomain.emit(response.body()!!)
            Log.d("APPLICATION","APPLIED SUCCESSFULLY")
        }
    }


}