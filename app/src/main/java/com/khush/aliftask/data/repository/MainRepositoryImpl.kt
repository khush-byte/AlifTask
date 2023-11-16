package com.khush.aliftask.data.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.khush.aliftask.data.database.AppDatabase
import com.khush.aliftask.data.database.ItemDbModel
import com.khush.aliftask.data.mapper.ItemMapper
import com.khush.aliftask.data.network.DataNetwork.BASE_URL
import com.khush.aliftask.data.models.ItemData
import com.khush.aliftask.domain.ItemRepository
import com.khush.aliftask.presentation.MainActivity.Companion.TAG

class MainRepositoryImpl(
    application: Application
): ItemRepository{

    private val itemDao = AppDatabase.getInstance(application).itemDao()
    private val mapper = ItemMapper()
    override fun getItemList(): LiveData<List<ItemData>> {
        return Transformations.map(itemDao.getItemList()) {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }
    suspend fun setItemList(items: List<ItemData>){
        itemDao.cleanDB()

        for(item in items) {
            itemDao.insertItem(ItemDbModel(BASE_URL+item.url, item.startDate, item.endDate, item.name, item.icon, item.venue.toString(), item.objType, item.loginRequired))
        }
    }
}