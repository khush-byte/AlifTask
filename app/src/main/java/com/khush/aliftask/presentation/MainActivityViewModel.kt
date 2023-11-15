package com.khush.aliftask.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khush.aliftask.data.network.DataNetwork
import com.khush.aliftask.data.network.models.DataFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    val response: MutableLiveData<DataFlow> = MutableLiveData()

    fun getDataFlow() {
        viewModelScope.launch {
            response.value = DataNetwork.retrofit.getDataFlow()
        }
    }
}