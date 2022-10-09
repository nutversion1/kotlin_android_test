package com.example.handlemultiplenetworkcall.repository

import com.example.handlemultiplenetworkcall.api.BoredApiService
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import retrofit2.Call
import retrofit2.Response

class BoredRepository(private val boredApiService: BoredApiService) {
    suspend fun searchActivity(participants: Int): Response<String>{
        delay(3000)

        return boredApiService.searchActivity(participants)
    }

}