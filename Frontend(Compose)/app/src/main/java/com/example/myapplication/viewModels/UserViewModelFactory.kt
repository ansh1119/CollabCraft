package com.example.myapplication.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Repository.ApiRepository
import com.example.myapplication.models.User

class UserViewModelFactory(private val apiRepository: ApiRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(apiRepository) as T
    }

}