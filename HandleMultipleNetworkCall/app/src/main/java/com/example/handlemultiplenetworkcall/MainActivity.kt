package com.example.handlemultiplenetworkcall

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.handlemultiplenetworkcall.api.ApiRequest
import com.example.handlemultiplenetworkcall.api.BoredApiService
import com.example.handlemultiplenetworkcall.repository.BoredRepository
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boredRepository = BoredRepository(ApiRequest.getBoredApiService())

        val viewModel: MainActivityViewModel by viewModels {MainActivityViewModel.Factory(boredRepository)}

        viewModel.sequenceChainingRequest()
        //viewModel.parallelChainingRequest()

    }
}