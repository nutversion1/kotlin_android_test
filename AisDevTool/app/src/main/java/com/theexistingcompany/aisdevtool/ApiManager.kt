package com.theexistingcompany.aisdevtool

import com.theexistingcompany.aisdevtool.api.EasyAppService
import com.theexistingcompany.aisdevtool.api.NetworkClient
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.core.KoinApplication.Companion.init
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager(
//    private val networkClient: NetworkClient,
) {
    val certificatePinner = CertificatePinner.Builder()
        .add(
            "mychannel.cloud.ais.th",
//            "dev-mychannel.cdc.ais.th",
//            "sha256/ZCOF65ADBWPDK8P2V7+mqodtvbsTRR/D74FCU+CEEA="
        "sha256/d981b04e65a58b4234dafb69889a1549cbb6b8307c1eae128f767ce31a529e10"
        )
        .build()

    fun prepaidIdentity(): EasyAppService = init(
        //networkClient.getMainEndpoint(),
        "https://mychannel.cloud.ais.th/api/",
//        "https://dev-mychannel.cdc.ais.th/api/",
        listOf()
    ).create(EasyAppService::class.java)

    private fun init(endpoint: String, interceptorList: List<Interceptor>): Retrofit {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val request: Request = chain.request().newBuilder()
//                .addHeader("x-authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkpBUlVXQU5OIiwidGltZXN0YW1wIjoiMTY2NTM5NjYzMjM5OSIsImxvY2F0aW9uQ29kZSI6IiIsImVtYWlsIjoiIiwiZmlyc3RuYW1lIjoiIiwibGFzdG5hbWUiOiIiLCJzaGFyZWRVc2VyIjoiamFydXdhbm4iLCJ1c2VyVHlwZSI6IiIsInJvbGUiOiJBSVMiLCJjaGFubmVsVHlwZSI6ImVhc3ktYXBwIiwiYXNjQ29kZSI6IiIsIm1vYmlsZU5vIjoiIiwic3ViIjoiQllQQVNTSURTIiwib3V0Q2huU2FsZXMiOiJTYWxlcyBQcm9tb3RlciIsIm91dEJ1c2luZXNzTmFtZSI6IiIsIm91dFBvc2l0aW9uIjoiU2FsZXMiLCJvdSI6IkVNUExPWUVFIiwiaWF0IjoxNjY1Mzk2NjQ2LCJleHAiOjE2NjU2NTU4NDZ9.8sxEtQgFd9kE6tYYRMG9nqO-NfqhASK-l_H38LVqLXo")
                .addHeader("channelType", "easy-app")
                .build()
            chain.proceed(request)
        }

        val client: OkHttpClient = httpClient
            .certificatePinner(certificatePinner)
            .build()

        return  Retrofit.Builder().apply {
            baseUrl(endpoint)
            //client(networkClient.getClient(interceptorList))
            client(client)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }


}
