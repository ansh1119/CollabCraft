package com.example.myapplication.retrofitHelper

import android.content.Context


class TokenManager(context: Context) {

    private val prefs = context.getSharedPreferences("PREFS_TOKEN_FILE", Context.MODE_PRIVATE)

    // Save token and username in shared preferences
    fun saveToken(token: String) {
        prefs.edit().putString("USER_TOKEN", token).apply()
    }

    fun saveUsername(username: String) {
        prefs.edit().putString("USER_NAME", username).apply()
    }

    // Retrieve token from shared preferences
    fun getToken(): String? {
        return prefs.getString("USER_TOKEN", null)
    }

    // Retrieve username from shared preferences
    fun getUsername(): String? {
        return prefs.getString("USER_NAME", null)
    }

    // Clear all saved data (optional - use during logout)
    fun clearData() {
        prefs.edit().clear().apply()
    }
}
