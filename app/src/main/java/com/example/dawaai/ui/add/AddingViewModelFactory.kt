package com.example.dawaai.ui.add

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddingViewModelFactory (private val application: Application):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AddingViewModel(application) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}