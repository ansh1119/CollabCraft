package com.example.myapplication.models

data class Tweet(
    val id: TweetId,
    val content: String,
    val domain: String,
    val time: String,
    val username: String,
    val likeCount: Int,
    val commentCount: Int,
    val hoursAgo: Int,
    val type: String,
    val imageUrl: String,
    val applications: List<Any>
)

data class TweetId(
    val timestamp: Long,
    val date: String
)
