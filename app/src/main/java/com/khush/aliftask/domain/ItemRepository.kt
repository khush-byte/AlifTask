package com.khush.aliftask.domain

import androidx.lifecycle.LiveData
import com.khush.aliftask.data.database.ItemDbModel
import com.khush.aliftask.data.models.ItemData

interface ItemRepository {
    fun getItemList(): LiveData<List<ItemData>>
}