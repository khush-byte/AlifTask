package com.khush.aliftask.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataNetwork {
    const val BASE_URL = "https://guidebook.com"

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DataAPI::class.java)
    }
}