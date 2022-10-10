package com.theexistingcompany.aisdevtool.api

import com.theexistingcompany.aisdevtool.model.AuthRequest
import com.theexistingcompany.aisdevtool.model.AuthResponse
import retrofit2.Call
import retrofit2.http.*

interface EasyAppService {
    @Headers("Content-Type: application/json")
    @POST("auth/ids")
    fun logIn(
        @Body authRequest: AuthRequest
    ): Call<AuthResponse>

    @GET("reliability/currentDate")
    fun currentDate(): Call<String>
}