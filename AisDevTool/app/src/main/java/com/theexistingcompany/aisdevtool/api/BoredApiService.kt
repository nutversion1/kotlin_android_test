package com.theexistingcompany.aisdevtool.api

import com.theexistingcompany.aisdevtool.model.ActivityResultData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BoredApiService {
    @GET("activity")
    fun findActivity(
        @Query("participants") participants: Int,
    ) : Call<ActivityResultData>
}