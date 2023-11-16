package com.khush.aliftask.data.mapper

import com.khush.aliftask.data.database.ItemDbModel
import com.khush.aliftask.data.network.DataNetwork.BASE_URL
import com.khush.aliftask.data.models.ItemData
import org.json.JSONObject

class ItemMapper {
    fun mapDbModelToEntity(dbModel: ItemDbModel): ItemData {
        return ItemData(
            url = dbModel.url,
            startDate = dbModel.startDate,
            endDate = dbModel.endDate,
            name = dbModel.name,
            icon = dbModel.icon,
            venue = JSONObject(dbModel.venue),
            objType = dbModel.objType,
            loginRequired = dbModel.loginRequired
        )
    }
}