package com.example.myapplication.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.Repository.PublicRepository
import com.example.myapplication.models.LoginRequest
import com.example.myapplication.models.User
import com.example.myapplication.retrofitHelper.RetrofitInstance
import com.example.myapplication.retrofitHelper.TokenManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import kotlin.math.log

class PublicViewModel(private val repository: PublicRepository) : ViewModel() {

    fun login(
        loginRequest: LoginRequest,
        tokenManager: TokenManager,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val token = repository.login(loginRequest)
                if (token != null) {
                    tokenManager.saveToken(token) // Save token
                    onSuccess()
                } else {
                    onError("Invalid username or password.")
                }
            } catch (e: Exception) {
                onError(e.message ?: "An unexpected error occurred.")
            }
        }
    }

    fun createUser(user: User, onSuccess: () -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                repository.createUser(user)
                onSuccess()
            } catch (e: Exception) {
                onError(e.message ?: "Failed to create user.")
            }
        }
    }
}
