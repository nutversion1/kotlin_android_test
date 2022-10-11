package com.theexistingcompany.aisdevtool.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.theexistingcompany.aisdevtool.baselib.Request
import com.theexistingcompany.aisdevtool.baselib.convert
import com.theexistingcompany.aisdevtool.model.*

class MainActivityViewModel(
    private val logInUseCase: LogInUseCase,
    private val checkDeathStatusUseCase: CheckDeathStatusUseCase,
    private val getCurrentDateUseCase: GetCurrentDateUseCase,
    private val queryEDocumentUseCase: QueryEDocumentUseCase,
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

    private val _checkDeathStatusUseCase = checkDeathStatusUseCase.observe()
    private val _checkDeathStatusSuccess = MediatorLiveData<CheckDeathStatusResponse?>()
    val checkDeathStatusSuccess
        get() = _checkDeathStatusSuccess
    private val _checkDeathStatusFailure = MediatorLiveData<String>()
    val checkDeathStatusFailure
        get() = _checkDeathStatusFailure
    private val _checkDeathStatusLoading = MediatorLiveData<Unit>()
    val checkDeathStatusLoading
        get() = _checkDeathStatusLoading

    private val _getCurrentDateUseCase = getCurrentDateUseCase.observe()
    private val _getCurrentDateSuccess = MediatorLiveData<GetCurrentDateResponse?>()
    val getCurrentDateSuccess
        get() = _getCurrentDateSuccess
    private val _getCurrentDateFailure = MediatorLiveData<String>()
    val getCurrentDateFailure
        get() = _getCurrentDateFailure
    private val _getCurrentDateLoading = MediatorLiveData<Unit>()
    val getCurrentDateLoading
        get() = _getCurrentDateLoading

    private val _queryEDocumentUseCase = queryEDocumentUseCase.observe()
    private val _queryEDocumentSuccess = MediatorLiveData<QueryEDocumentResponse?>()
    val queryEDocumentSuccess
        get() = _queryEDocumentSuccess
    private val _queryEDocumentFailure = MediatorLiveData<String>()
    val queryEDocumentFailure
        get() = _queryEDocumentFailure
    private val _queryEDocumentLoading = MediatorLiveData<Unit>()
    val queryEDocumentLoading
        get() = _queryEDocumentLoading

    init {
        _logInUseCase.convert(
            liveData = _logInSuccess,
            success = { data -> _logInSuccess.postValue(data) },
            failure = { exception -> _loginFailure.postValue(exception.message) },
            loading = { _loginLoading.postValue(Unit) }
        )

        _checkDeathStatusUseCase.convert(
            liveData = _checkDeathStatusSuccess,
            success = { data -> _checkDeathStatusSuccess.postValue(data) },
            failure = { exception -> _checkDeathStatusFailure.postValue(exception.message) },
            loading = { _checkDeathStatusLoading.postValue(Unit) }
        )

        _getCurrentDateUseCase.convert(
            liveData = _getCurrentDateSuccess,
            success = { data -> _getCurrentDateSuccess.postValue(data) },
            failure = { exception -> _getCurrentDateFailure.postValue(exception.message) },
            loading = { _getCurrentDateLoading.postValue(Unit) }
        )

        _queryEDocumentUseCase.convert(
            liveData = _queryEDocumentSuccess,
            success = { data -> _queryEDocumentSuccess.postValue(data) },
            failure = { exception -> _queryEDocumentFailure.postValue(exception.message) },
            loading = { _queryEDocumentLoading.postValue(Unit) }
        )
    }

    fun logIn(username: String?, password: String?) {
        val request = AuthRequest(
            username = username,
            password = password,
        )
        logInUseCase.execute(Request(request, needFresh = true))
    }

    fun checkDeathStatus(idCardNo: String?, birthDate: String?) {
        val request = CheckDeathStatusRequest(
            idCardNo = idCardNo,
            birthDate = birthDate,
        )
        checkDeathStatusUseCase.execute(Request(request, needFresh = true))
    }

    fun getCurrentDate() {
        getCurrentDateUseCase.execute(Request("", needFresh = true))
    }

    fun queryEDocument(orderType: String?, docType: String?) {
        val request = QueryEDocumentRequest(
            orderType = orderType,
            docType = docType,
        )
        queryEDocumentUseCase.execute(Request(request, needFresh = true))
    }
}