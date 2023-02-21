package com.example.dawaai.ui.mainScreenFragment

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.dawaai.data.localy.getDatabase
import com.example.dawaai.repository.ItemRepository
import kotlinx.coroutines.launch

class MainScreenViewModel(
    application: Application,
) : AndroidViewModel(application) {

     private val TAG = "MainScreenViewModel"
    private val database = getDatabase(application)
    private val itemRepo = ItemRepository(database)

    var items = itemRepo.items

    init {

        viewModelScope.launch {
            try {
                itemRepo.refreshData()
            } catch (e: Exception) {
                Log.e(TAG, " Exception ${e.message}")
            }
        }
    }


}