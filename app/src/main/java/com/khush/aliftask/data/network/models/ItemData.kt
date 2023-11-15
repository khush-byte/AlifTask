package com.khush.aliftask.data.network.models

import org.json.JSONObject

data class ItemData(
    val url: String,
    val startDate: String,
    val endDate: String,
    val name: String,
    val icon: String,
    val venue: JSONObject,
    val objType: String,
    val loginRequired: Boolean
)
