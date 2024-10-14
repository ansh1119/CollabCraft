package com.example.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.models.Tweet
import com.example.myapplication.models.TweetResponse
import com.example.myapplication.retrofitHelper.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class TweetViewModel(private var repository:ApiRepository) : ViewModel() {
//    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
val tweets: StateFlow<List<TweetResponse>> get() = repository.tweets

    init {
        Log.d("I AM HERE","working good")
        viewModelScope.launch {
            try {
                Log.d("SUCCESSFUL CALL","working good")
                val response = repository.getTweets()
                Log.d("YE LE TERI CALL",response.toString())
            } catch (e: HttpException) {
                Log.w("HTTP ERROR",e.toString())
            } catch (e: Exception) {
                Log.w("EXCEPTION OCCURED",e.toString())
            }
        }
    }
}
