package com.example.handlemultiplenetworkcall.repository

import com.example.handlemultiplenetworkcall.api.BoredApiService
import retrofit2.Call

class BoredRepository(private val boredApiService: BoredApiService) {
    fun searchActivity(participants: Int): Call<String> =
        boredApiService.searchActivity(participants)
}