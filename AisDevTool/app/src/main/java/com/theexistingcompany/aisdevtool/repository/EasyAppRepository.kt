package com.theexistingcompany.aisdevtool.repository

import androidx.lifecycle.LiveData
import com.theexistingcompany.aisdevtool.api.EasyAppService
import com.theexistingcompany.aisdevtool.baselib.DirectNetworkBoundResource
import com.theexistingcompany.aisdevtool.baselib.Request
import com.theexistingcompany.aisdevtool.baselib.Result
import com.theexistingcompany.aisdevtool.model.AuthRequest
import com.theexistingcompany.aisdevtool.model.AuthResponse
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

//    fun checkDeathStatus(request: Request<CheckDeathStatusRequest>): LiveData<Result<CheckDeathStatusReponse?>> =
//        object : DirectNetworkBoundResource<CheckDeathStatusReponse?, CheckDeathStatusReponse>() {
//            override fun createCall(): Response<CheckDeathStatusReponse> =
//                piService.checkDeathStatus(request.value).execute()
//
//            override fun convertToResultType(response: CheckDeathStatusReponse): CheckDeathStatusReponse =
//                response
//
//            override fun callFailed(errorMessage: String) {
//            }
//        }.asLiveData()
}