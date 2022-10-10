package com.theexistingcompany.aisdevtool

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.theexistingcompany.aisdevtool.api.EasyAppService
import com.theexistingcompany.aisdevtool.model.AuthRequest
import com.theexistingcompany.aisdevtool.model.AuthResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private val imageView by lazy{ findViewById<ImageView>(R.id.imageView) }
    private val displayTextView by lazy{ findViewById<TextView>(R.id.displayTextView) }
    private val button by lazy{ findViewById<TextView>(R.id.button) }

    private val easyAppApiRetrofit by lazy {
        val httpClient = OkHttpClient.Builder()

        httpClient.addInterceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("x-authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6IkpBUlVXQU5OIiwidGltZXN0YW1wIjoiMTY2NTM4NDIzNzA3NiIsImxvY2F0aW9uQ29kZSI6IiIsImVtYWlsIjoiIiwiZmlyc3RuYW1lIjoiIiwibGFzdG5hbWUiOiIiLCJzaGFyZWRVc2VyIjoiamFydXdhbm4iLCJ1c2VyVHlwZSI6IiIsInJvbGUiOiJBSVMiLCJjaGFubmVsVHlwZSI6ImVhc3ktYXBwIiwiYXNjQ29kZSI6IiIsIm1vYmlsZU5vIjoiIiwic3ViIjoiQllQQVNTSURTIiwib3V0Q2huU2FsZXMiOiJTYWxlcyBQcm9tb3RlciIsIm91dEJ1c2luZXNzTmFtZSI6IiIsIm91dFBvc2l0aW9uIjoiU2FsZXMiLCJvdSI6IkVNUExPWUVFIiwiaWF0IjoxNjY1Mzg0MjQ4LCJleHAiOjE2NjU0NzA2NDh9.EYqeZMxOmfkMBlCQrOO_dvtwiQjCC919jOUWd21VEfc")
                .addHeader("channelType", "easy-app")
                .build()
            chain.proceed(request)
        }

        val client: OkHttpClient = httpClient.build()

        Retrofit.Builder()
            .baseUrl("http://dev-mychannel.cdc.ais.th/api/")
            .client(client)
            //.addConverterFactory(MoshiConverterFactory.create())
            //.addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val easyAppService by lazy {
        easyAppApiRetrofit.create(EasyAppService::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            getEasyAppResponse()
        }


    }

    private fun getEasyAppResponse() {
        val call = easyAppService.logIn(AuthRequest("jaruwann", "0"))
        //val call = easyAppService.currentDate())

        call.enqueue(object : Callback<AuthResponse> {
            override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                displayTextView.text = "Failed to get find results: $t"
            }

            override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                if (response.isSuccessful) {

                    displayTextView.text = "response: ${response.body()}"
                } else {
                    displayTextView.text = "fail: ${response.message()}"
                }
            }
        })
    }


}