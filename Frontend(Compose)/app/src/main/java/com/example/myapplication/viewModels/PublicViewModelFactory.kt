package com.example.myapplication.viewModels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.Repository.PublicRepository
import com.example.myapplication.retrofitHelper.TokenManager

class PublicViewModelFactory(
    private val publicRepository: PublicRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PublicViewModel::class.java)) {
            return PublicViewModel(publicRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}
