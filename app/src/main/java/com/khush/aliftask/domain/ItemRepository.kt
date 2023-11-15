package com.khush.aliftask.domain

import androidx.lifecycle.LiveData
import com.khush.aliftask.data.network.models.ItemData

interface ItemRepository {
    fun itemList(): LiveData<List<ItemData>>
}