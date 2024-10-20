package com.example.myapplication.retrofitHelper

import android.content.Context


class TokenManager(context: Context) {

    private var prefs = context.getSharedPreferences("PREFS_TOKEN_FILE", Context.MODE_PRIVATE)

    // Save token in shared preferences
    fun saveToken(token: String) {
        val editor = prefs.edit()
        editor.putString("USER_TOKEN", token)
        editor.apply()
    }

    // Retrieve token from shared preferences
    fun getToken(): String? {
        return prefs.getString("USER_TOKEN", null)
    }
}
