package com.example.handlemultiplenetworkcall.api

import com.example.handlemultiplenetworkcall.model.Activity
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface BoredApiService {
    @GET("activity")
    suspend fun searchActivity(
        @Query("participants") participants: Int
    ): Response<Activity>
}