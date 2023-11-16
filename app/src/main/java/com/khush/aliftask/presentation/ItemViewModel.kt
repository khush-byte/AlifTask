package com.khush.aliftask.presentation

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.khush.aliftask.data.network.DataNetwork
import com.khush.aliftask.data.models.DataFlow
import com.khush.aliftask.data.models.ItemData
import com.khush.aliftask.data.repository.MainRepositoryImpl
import com.khush.aliftask.domain.GetItemListUseCase
import com.khush.aliftask.presentation.MainActivity.Companion.TAG
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application){
    private val repository = MainRepositoryImpl(application)
    private val getItemListUseCase = GetItemListUseCase(repository)

    val itemList = getItemListUseCase()

    fun getDataFlow() {
        viewModelScope.launch {
            try {
                val response = DataNetwork.retrofit.getDataFlow()
                if(response.data.isNotEmpty()) {
                    repository.setItemList(response.data)
                }
            }catch (e: Exception){
                e.message?.let { Log.d(TAG, it) }
            }
        }
    }
}