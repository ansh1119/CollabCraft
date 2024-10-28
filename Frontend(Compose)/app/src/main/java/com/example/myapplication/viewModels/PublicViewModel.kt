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
                val token: String? = repository.login(loginRequest) // Now matches the repository return type

                if (token != null) {
                    Log.d("TOKEN", token) // Log the token
                    tokenManager.saveToken(token) // Save the token using TokenManager
                    onSuccess() // Call success callback
                } else {
                    onError("Invalid username or password.") // Handle invalid login
                }
            } catch (e: HttpException) {
                Log.e("HTTP_EXCEPTION", "HttpException: ${e.response()?.errorBody()?.string()}")
                onError("Server error: ${e.message}")
            } catch (e: Exception) {
                Log.e("EXCEPTION", "Login error: ${e.localizedMessage}")
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
