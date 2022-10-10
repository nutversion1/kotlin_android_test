package com.theexistingcompany.aisdevtool

import android.util.Log
import com.theexistingcompany.aisdevtool.baselib.MediatorUseCase
import com.theexistingcompany.aisdevtool.baselib.Request
import com.theexistingcompany.aisdevtool.baselib.Result
import com.theexistingcompany.aisdevtool.model.AuthRequest
import com.theexistingcompany.aisdevtool.model.AuthResponse
import com.theexistingcompany.aisdevtool.repository.EasyAppRepository


class LogInUseCase constructor(
    private var easyAppRepository: EasyAppRepository,
) : MediatorUseCase<Request<AuthRequest>, AuthResponse?>() {
    override fun execute(parameters: Request<AuthRequest>) {

        result.addSource(easyAppRepository.logIn(parameters)) {
            when (it) {
                is Result.Success -> {
//                    Log.d("myDebug", "success")
                    result.postValue(Result.Success(it.data))
                }
                is Result.Error -> {
//                    Log.d("myDebug", "error")
//                    val resultCode = it.exception.message?.toErrorResult()?.resultCode
//                    val errorMessage = errorMapper.getErrorMessage(resultCode)
//                    result.postValue(Result.Error(Exception(errorMessage)))
                    result.postValue(it)
                }
                is Result.Loading -> {
//                    Log.d("myDebug", "loading")
                    result.postValue(Result.Loading)
                }
            }
        }

    }
}