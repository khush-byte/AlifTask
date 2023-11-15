package com.khush.aliftask.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.json.JSONObject

@Entity(tableName = "item_data")
data class ItemDbModel(
    @PrimaryKey
    val url: String,
    val startDate: String,
    val endDate: String,
    val name: String,
    val icon: String,
    val venue: String,
    val objType: String,
    val loginRequired: Boolean
)
