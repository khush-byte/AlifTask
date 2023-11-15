package com.khush.aliftask.data.network

import com.khush.aliftask.data.network.models.DataFlow
import retrofit2.http.GET

interface DataAPI {
    @GET("service/v2/upcomingGuides")
    suspend fun getDataFlow(): DataFlow
}