package com.theexistingcompany.aisdevtool.api

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.io.IOException
import java.io.InputStream
import java.lang.IllegalStateException
import java.security.KeyManagementException
import java.security.KeyStore
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

class NetworkClient constructor(
//    private val tokenManager: TokenManager,
//    private val endpointManager: EndpointManager,
//    private val defaultConnectionSpec: DefaultConnectionSpec,
//    private val locationUtility: LocationUtility,
    private val context: Context
) {
    fun getMainEndpoint() = ""

//    fun getMainEndpoint() = endpointManager.getMainEndpoint()

//    fun getCardOcrEndpoint() = endpointManager.getCardOcrEndpoint()
//
//    fun getDataPrivacyEndpoint() = endpointManager.getDataPrivacyEndpoint()
//
//    fun getPiOfflineEndpoint() = endpointManager.getPiOfflineEndpoint()
//
//    fun getNewRegisterOfflineEndpoint() = endpointManager.getNewRegisterOfflineEndpoint()
//
//    fun getClient(interceptorList: List<Interceptor>): OkHttpClient {
//
//        val trustedCertificate = getTrustedCertificate()
//        val trustManagerFactory = getTrustManagerFactory(trustedCertificate)
//        val sslContext = getSSLContext(trustManagerFactory)
//        val trustManager = getX509TrustManager(trustManagerFactory)
//
//        return OkHttpClient().newBuilder().apply {
//            readTimeout(30, TimeUnit.SECONDS)
//            connectTimeout(20, TimeUnit.SECONDS)
//            addInterceptor(getRequestInterceptor())
//            addInterceptor(getLocationInterceptor())
//            addInterceptor(OkHttp3Helper.getPinningInterceptor())
//            interceptorList.forEach { interceptor: Interceptor -> addInterceptor(interceptor) }
//            if(BuildConfig.DEBUG){
//                addInterceptor(getHttpLoggingInterceptor())
//                addNetworkInterceptor(StethoInterceptor())
//            }
//            hostnameVerifier(HostnameVerifier { _, _ -> true })
//            connectionSpecs(defaultConnectionSpec.getConnectionSpec())
//        }.build()
//    }
//
//    private fun getTrustedCertificate(): KeyStore? {
//        var trusted: KeyStore? = null
//        var inputStream: InputStream? = null
//        try {
//            trusted = KeyStore.getInstance("BKS")
//            if (BuildConfig.DEBUG) {
//                inputStream =
//                    context.resources.openRawResource(com.nextzy.easyapp.android.R.raw.easy_dev)
//            } else {
//                inputStream =
//                    context.resources.openRawResource(com.nextzy.easyapp.android.R.raw.easy_pro)
//            }
//            trusted.load(inputStream , "mysecret".toCharArray())
//        } catch (e: KeyStoreException) {
//            e.printStackTrace()
//        } catch (e: CertificateException) {
//            e.printStackTrace()
//        } catch (e: NoSuchAlgorithmException) {
//            e.printStackTrace()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        } finally {
//            if (inputStream != null) {
//                try {
//                    inputStream.close()
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//            }
//        }
//        return trusted
//    }
//
//    private fun getTrustManagerFactory(trustedCertificate: KeyStore?): TrustManagerFactory? {
//        var trustManagerFactory: TrustManagerFactory? = null
//        try {
//            trustManagerFactory =
//                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
//            trustManagerFactory.init(trustedCertificate)
//        } catch (e: NoSuchAlgorithmException) {
//            e.printStackTrace()
//        } catch (e: KeyStoreException) {
//            e.printStackTrace()
//        }
//        return trustManagerFactory
//    }
//
//    private fun getSSLContext(trustManagerFactory: TrustManagerFactory?): SSLContext? {
//        var sslContext: SSLContext? = null
//        try {
//            sslContext = SSLContext.getInstance("TLS")
//            sslContext.init(null, trustManagerFactory?.trustManagers, null)
//        } catch (e: NoSuchAlgorithmException) {
//            e.printStackTrace()
//        } catch (e: KeyManagementException) {
//            e.printStackTrace()
//        }
//        return sslContext
//    }
//
//    private fun getX509TrustManager(trustManagerFactory: TrustManagerFactory?): X509TrustManager? {
//        val trustManagers = trustManagerFactory?.trustManagers
//        if (trustManagers == null || trustManagers.size != 1 || trustManagers[0] !is X509TrustManager
//        ) {
//            val e = IllegalStateException("Wrong trust manager: " + Arrays.toString(trustManagers))
//            throw e
//        }
//        return trustManagers[0] as X509TrustManager
//    }
//
//    private fun getHttpLoggingInterceptor(): Interceptor {
//        val interceptor = HttpLoggingInterceptor(ApiLogger())
//        interceptor.level = HttpLoggingInterceptor.Level.BODY
//        return interceptor
//    }
//
//    class ApiLogger : HttpLoggingInterceptor.Logger {
//        override fun log(message: String) {
//            if (message.startsWith("{") || message.startsWith("[")) {
//                try {
//                    val prettyPrintJson = GsonBuilder().setPrettyPrinting()
//                        .create().toJson(JsonParser.parseString(message))
//                    Timber.d(" \n$prettyPrintJson")
//                } catch (m: JsonSyntaxException) {
//                    Timber.d(message)
//                }
//            } else {
//                Timber.d(message)
//                return
//            }
//        }
//    }
//
//    private fun getRequestInterceptor(): Interceptor {
//        return Interceptor { chain ->
//            val request = chain.request().newBuilder().apply {
//                addHeader("channeltype", "easy-app")
//                addHeader("Content-Type", "application/json;charset=utf-8")
//                addHeader("x-authorization", "Bearer ${tokenManager.getAccessToken()}")
//            }.build()
//            chain.proceed(request)
//        }
//    }
//
//    private fun getLocationInterceptor(): Interceptor = LocationInterceptor(locationUtility)
}