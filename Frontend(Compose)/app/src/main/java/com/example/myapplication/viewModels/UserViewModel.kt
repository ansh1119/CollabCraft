package com.example.myapplication.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.models.Tweet
import com.example.myapplication.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserViewModel(private var repository:ApiRepository):ViewModel() {

    fun authentication(user:User) {
        viewModelScope.launch {
            try {
                Log.d("SUCCESSFUL CALL","working good")
                val response = repository.createUser(user)
                Log.d("YE LE TERI CALL",response.toString())
            } catch (e: HttpException) {
                Log.w("HTTP ERROR",e.toString())
            } catch (e: Exception) {
                Log.w("EXCEPTION OCCURED",e.toString())
            }
        }
    }

}