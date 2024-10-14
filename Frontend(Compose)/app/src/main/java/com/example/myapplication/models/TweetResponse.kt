package com.example.myapplication.models

data class TweetResponse(
    val applications: List<String>,
    val author: String,
    val content: String,
    val domain: String,
    val id: String,
    val time: String
)