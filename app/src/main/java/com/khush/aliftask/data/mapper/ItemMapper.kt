package com.khush.aliftask.data.mapper

import com.khush.aliftask.data.database.ItemDbModel
import com.khush.aliftask.data.network.DataNetwork.BASE_URL
import com.khush.aliftask.data.network.models.ItemData

class ItemMapper {
    fun mapDtoToDbModel(dto: ItemData) = ItemDbModel(
        url = "$BASE_URL +/+ ${dto.url}",
        startDate = dto.startDate,
        endDate = dto.endDate,
        name = dto.name,
        icon = dto.icon,
        venue = dto.venue.toString(),
        objType = dto.objType,
        loginRequired = dto.loginRequired
    )
}