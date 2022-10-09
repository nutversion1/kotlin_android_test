package com.example.handlemultiplenetworkcall

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.handlemultiplenetworkcall.repository.BoredRepository
import kotlinx.coroutines.Delay
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.concurrent.schedule

class MainActivityViewModel(private val repository: BoredRepository) : ViewModel() {
    fun sequenceChainingRequest() {
        viewModelScope.launch {
            Log.d("myDebug", "1")
            val result1 = repository.searchActivity(1).body()
            Log.d("myDebug", "r1: $result1")

            Log.d("myDebug", "2")
            val result2 = repository.searchActivity(2).body()
            Log.d("myDebug", "r2: $result2")

            Log.d("myDebug", "3")
            val result3 = repository.searchActivity(3).body()
            Log.d("myDebug", "r3: $result3")
        }
    }

    fun parallelChainingRequest() {
        viewModelScope.launch {
            Log.d("myDebug", "1")
            val getObject1Task = async { repository.searchActivity(1) }

            Log.d("myDebug", "2")
            val getObject2Task = async { repository.searchActivity(2) }

            Log.d("myDebug", "3")
            val getObject3Task = async { repository.searchActivity(3) }

            val r1 = getObject1Task.await().body()
            Log.d("myDebug", "r1: $r1 ")

            val r2 = getObject2Task.await().body()
            Log.d("myDebug", "r2: $r2")

            val r3 = getObject3Task.await().body()
            Log.d("myDebug", "r3: $r3")
        }
    }

    class Factory(private val repository: BoredRepository) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainActivityViewModel(repository) as T
        }
    }
}


