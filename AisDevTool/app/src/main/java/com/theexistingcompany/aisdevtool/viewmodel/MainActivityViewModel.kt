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
    private val queryEDocumentTCUseCase: QueryEDocumentUseCase,
    private val queryEDocumentConsentUseCase: QueryEDocumentUseCase,
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

    private val _queryEDocumentTCUseCase = queryEDocumentTCUseCase.observe()
    private val _queryEDocumentTCSuccess = MediatorLiveData<QueryEDocumentResponse?>()
    val queryEDocumentTCSuccess
        get() = _queryEDocumentTCSuccess
    private val _queryEDocumentTCFailure = MediatorLiveData<String>()
    val queryEDocumentTCFailure
        get() = _queryEDocumentTCFailure
    private val _queryEDocumentTCLoading = MediatorLiveData<Unit>()
    val queryEDocumentTCLoading
        get() = _queryEDocumentTCLoading

    private val _queryEDocumentConsentUseCase = queryEDocumentConsentUseCase.observe()
    private val _queryEDocumentConsentSuccess = MediatorLiveData<QueryEDocumentResponse?>()
    val queryEDocumentConsentSuccess
        get() = _queryEDocumentConsentSuccess
    private val _queryEDocumentConsentFailure = MediatorLiveData<String>()
    val queryEDocumentConsentFailure
        get() = _queryEDocumentConsentFailure
    private val _queryEDocumentConsentLoading = MediatorLiveData<Unit>()
    val queryEDocumentConsentLoading
        get() = _queryEDocumentConsentLoading

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

        _queryEDocumentTCUseCase.convert(
            liveData = _queryEDocumentTCSuccess,
            success = { data -> _queryEDocumentTCSuccess.postValue(data) },
            failure = { exception -> _queryEDocumentTCFailure.postValue(exception.message) },
            loading = { _queryEDocumentTCLoading.postValue(Unit) }
        )

        _queryEDocumentConsentUseCase.convert(
            liveData = _queryEDocumentConsentSuccess,
            success = { data -> _queryEDocumentConsentSuccess.postValue(data) },
            failure = { exception -> _queryEDocumentConsentFailure.postValue(exception.message) },
            loading = { _queryEDocumentConsentLoading.postValue(Unit) }
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

    fun queryEDocumentTC() {
        val request = QueryEDocumentRequest(
            orderType = "PI",
            docType = "TC",
        )
        queryEDocumentTCUseCase.execute(Request(request, needFresh = true))
    }

    fun queryEDocumentConsent() {
        val request = QueryEDocumentRequest(
            orderType = "PI",
            docType = "Consent",
        )
        queryEDocumentConsentUseCase.execute(Request(request, needFresh = true))
    }
}