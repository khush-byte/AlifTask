package com.khush.aliftask.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.khush.aliftask.data.database.AppDatabase
import com.khush.aliftask.data.mapper.ItemMapper
import com.khush.aliftask.data.network.models.ItemData
import com.khush.aliftask.domain.ItemRepository

class MainRepositoryImpl(
    private val application: Application
): ItemRepository{

    private val itemDao = AppDatabase.getInstance(application).itemDao()
    private val mapper = ItemMapper()

    override fun itemList(): LiveData<List<ItemData>> {
        TODO("Not yet implemented")
    }
}