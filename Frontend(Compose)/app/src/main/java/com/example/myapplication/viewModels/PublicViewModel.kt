package com.example.myapplication.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.Repository.PublicRepository
import com.example.myapplication.models.User
import com.example.myapplication.retrofitHelper.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response

class PublicViewModel(private var repository: PublicRepository):ViewModel(){
    var emptyUser:User=User("","","","","","","", 0.toString())


    fun createUser(user:User) {
        viewModelScope.launch {
            try {
                val response = repository.createUser(user)
                Log.d("CREATION",response.toString())
            } catch (e: HttpException) {
                Log.w("CREATION HTTP EXCEPTION", e.toString())
            } catch (e: Exception) {
                Log.w("CREATION EXCEPTION", e.toString())
            }
        }
    }

    private fun login(user:User){
        viewModelScope.launch {
            try {
                val response = repository.login(user)
                Log.d("CREATION",response.toString())
            } catch (e: HttpException) {
                Log.w("CREATION HTTP EXCEPTION", e.toString())
            } catch (e: Exception) {
                Log.w("CREATION EXCEPTION", e.toString())
            }
        }
    }


}