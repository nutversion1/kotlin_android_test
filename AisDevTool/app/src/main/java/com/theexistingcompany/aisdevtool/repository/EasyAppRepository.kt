package com.theexistingcompany.aisdevtool.repository

import androidx.lifecycle.LiveData
import com.theexistingcompany.aisdevtool.api.EasyAppService
import com.theexistingcompany.aisdevtool.baselib.DirectNetworkBoundResource
import com.theexistingcompany.aisdevtool.baselib.Request
import com.theexistingcompany.aisdevtool.baselib.Result
import com.theexistingcompany.aisdevtool.model.*
import retrofit2.Response

class EasyAppRepository(private val easyAppService: EasyAppService){
    fun logIn(request: Request<AuthRequest>): LiveData<Result<AuthResponse?>> =
        object : DirectNetworkBoundResource<AuthResponse?, AuthResponse>() {
            override fun createCall(): Response<AuthResponse> =
                easyAppService.logIn(request.value).execute()

            override fun convertToResultType(response: AuthResponse): AuthResponse =
                response

            override fun callFailed(errorMessage: String) {
            }

        }.asLiveData()

    fun checkDeathStatus(request: Request<CheckDeathStatusRequest>): LiveData<Result<CheckDeathStatusResponse?>> =
        object : DirectNetworkBoundResource<CheckDeathStatusResponse?, CheckDeathStatusResponse>() {
            override fun createCall(): Response<CheckDeathStatusResponse> =
                easyAppService.checkDeathStatus(request.value).execute()

            override fun convertToResultType(response: CheckDeathStatusResponse): CheckDeathStatusResponse =
                response

            override fun callFailed(errorMessage: String) {
            }
        }.asLiveData()

    fun getCurrentDate(request: Request<String>): LiveData<Result<GetCurrentDateResponse?>> =
        object : DirectNetworkBoundResource<GetCurrentDateResponse?, GetCurrentDateResponse>() {
            override fun createCall(): Response<GetCurrentDateResponse> =
                easyAppService.getCurrentDate().execute()

            override fun convertToResultType(response: GetCurrentDateResponse): GetCurrentDateResponse? = response

            override fun callFailed(errorMessage: String) {
            }
        }.asLiveData()

    fun queryEDocument(request: Request<QueryEDocumentRequest>): LiveData<Result<QueryEDocumentResponse?>> =
        object : DirectNetworkBoundResource<QueryEDocumentResponse?, QueryEDocumentResponse>() {
            override fun createCall(): Response<QueryEDocumentResponse> =
                easyAppService.queryEDocument(request.value).execute()

            override fun convertToResultType(response: QueryEDocumentResponse): QueryEDocumentResponse =
                response

            override fun callFailed(errorMessage: String) {
            }
        }.asLiveData()
}