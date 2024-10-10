package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.screens.HomeScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewmodel.TweetViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("IN","nothing")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        val tweetViewModel = ViewModelProvider(this)[TweetViewModel::class.java]
        setContent {
            MyApplicationTheme {
                Log.d("IN","nothing")
                App()
            }
        }
    }
}

