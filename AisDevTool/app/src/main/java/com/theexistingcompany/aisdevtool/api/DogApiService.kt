package com.theexistingcompany.aisdevtool.api

import com.theexistingcompany.aisdevtool.model.DogResultData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DogApiService {
    @GET("breeds/image/random")
    fun searchImage() : Call<DogResultData>
}