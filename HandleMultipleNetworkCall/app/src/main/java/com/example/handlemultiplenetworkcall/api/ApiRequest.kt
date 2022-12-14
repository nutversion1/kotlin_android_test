package com.example.handlemultiplenetworkcall.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ApiRequest {
    fun getBoredApiService(): BoredApiService {
        return Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(BoredApiService::class.java)
    }
}