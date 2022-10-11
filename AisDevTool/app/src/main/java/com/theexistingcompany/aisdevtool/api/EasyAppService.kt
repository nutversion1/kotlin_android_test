package com.theexistingcompany.aisdevtool.api

import com.theexistingcompany.aisdevtool.model.*
import retrofit2.Call
import retrofit2.http.*

interface EasyAppService {
    @POST("auth/ids")
    fun logIn(
        @Body authRequest: AuthRequest
    ): Call<AuthResponse>

    @POST("reliability/check-death-status")
    fun checkDeathStatus(
        @Body checkDeathStatusRequest: CheckDeathStatusRequest
    ): Call<CheckDeathStatusResponse>

    @GET("reliability/currentDate")
    fun getCurrentDate(): Call<GetCurrentDateResponse>

    @POST("reliability/query-edocument")
    fun queryEDocument(
        @Body queryEDocumentRequest: QueryEDocumentRequest
    ): Call<QueryEDocumentResponse>

//    @GET("reliability/validate-sim-format/{simSerial}")
//    fun validateSimFormat(
//        @Path("simSerial") simSerial: String?
//    ): Call<ValidateSimFormatResponse>
}