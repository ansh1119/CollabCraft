package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.models.Tweet
import com.example.myapplication.retrofitHelper.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class TweetViewModel : ViewModel() {
    private val _tweets = MutableStateFlow<List<Tweet>>(emptyList())
    val tweets: StateFlow<List<Tweet>> get() = _tweets

    init {
        fetchTweets()
    }

    fun fetchTweets() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTweets()
                _tweets.value = response
            } catch (e: HttpException) {
                _tweets.value = emptyList()
            } catch (e: Exception) {
                _tweets.value = emptyList()
            }
        }
    }
}
