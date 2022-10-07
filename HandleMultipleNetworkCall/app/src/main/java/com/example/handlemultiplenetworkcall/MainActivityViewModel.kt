package com.example.handlemultiplenetworkcall

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.handlemultiplenetworkcall.repository.BoredRepository
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(private val repository: BoredRepository) : ViewModel() {
    fun chainingRequest() {
        viewModelScope.launch {
            val result1 = repository.searchActivity(1)
            val result2 = repository.searchActivity(2)
            val result3 = repository.searchActivity(3)

            result1.enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("myDebug", "fail: $t")
                }
                override fun onResponse(
                    call: Call<String>,
                    response: Response<String>
                ) {
                    if (response.isSuccessful) {
                        Log.d("myDebug", "success: ${response.body()}")
                    }
                }
            })

            result2.enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("myDebug", "fail: $t")
                }
                override fun onResponse(
                    call: Call<String>,
                    response: Response<String>
                ) {
                    if (response.isSuccessful) {
                        Log.d("myDebug", "success: ${response.body()}")
                    }
                }
            })

            result3.enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.d("myDebug", "fail: $t")
                }
                override fun onResponse(
                    call: Call<String>,
                    response: Response<String>
                ) {
                    if (response.isSuccessful) {
                        Log.d("myDebug", "success: ${response.body()}")
                    }
                }
            })
        }
    }

    class Factory(private val repository: BoredRepository) : ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainActivityViewModel(repository) as T
        }
    }
}


