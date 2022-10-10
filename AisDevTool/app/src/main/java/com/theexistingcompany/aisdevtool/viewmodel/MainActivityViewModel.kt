package com.theexistingcompany.aisdevtool.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.theexistingcompany.aisdevtool.LogInUseCase
import com.theexistingcompany.aisdevtool.baselib.Request
import com.theexistingcompany.aisdevtool.baselib.convert
import com.theexistingcompany.aisdevtool.model.AuthRequest
import com.theexistingcompany.aisdevtool.model.AuthResponse

class MainActivityViewModel(
    private val logInUseCase: LogInUseCase
//    private val checkDeathStatusUseCase: CheckDeathStatusUseCase,
    ) : ViewModel() {

    private val _logInUseCase = logInUseCase.observe()
    private val _logInSuccess = MediatorLiveData<AuthResponse?>()
    val logInSuccess
        get() = _logInSuccess
    private val _loginFailure = MediatorLiveData<String>()
    val loginFailure
        get() = _loginFailure
    private val _loginLoading = MediatorLiveData<Unit>()
    val loginLoading
        get() = _loginLoading

    init {
        _logInUseCase.convert(
            liveData = _logInSuccess,
            success = { data -> _logInSuccess.postValue(data) },
            failure = { exception -> _loginFailure.postValue(exception.message) },
            loading = { _loginLoading.postValue(Unit) }
        )
    }

    fun logIn(username: String?, password: String?) {
        val request = AuthRequest(
            username = username,
            password = password
        )
        logInUseCase.execute(Request(request, needFresh = true))
    }

//    fun checkDeathStatus(idCardNo: String?, birthDate: String?) {
//        val request = CheckDeathStatusRequest(
//            idCardNo = idCardNo,
//            birthDate = birthDate
//        )
//        checkDeathStatusUseCase.execute(Request(request, needFresh = true))
//    }
}