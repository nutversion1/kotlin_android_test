package com.theexistingcompany.aisdevtool

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.theexistingcompany.aisdevtool.api.BoredApiService
import com.theexistingcompany.aisdevtool.api.DogApiService
import com.theexistingcompany.aisdevtool.model.ActivityResultData
import com.theexistingcompany.aisdevtool.model.DogResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    private val imageView by lazy{ findViewById<ImageView>(R.id.imageView) }
    private val displayTextView by lazy{ findViewById<TextView>(R.id.displayTextView) }
    private val button by lazy{ findViewById<TextView>(R.id.button) }

    private val imageLoader: ImageLoader by lazy{ GlideImageLoader(this) }

    private val boredApiRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.boredapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            //.addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }
    private val boredApiService by lazy {
        boredApiRetrofit.create(BoredApiService::class.java)
    }

    private val dogApiRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            //.addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }
    private val dogApiService by lazy {
        dogApiRetrofit.create(DogApiService::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            //getActivityResponse()
            getDogResponse()
        }
    }

    private fun getActivityResponse() {
        val call = boredApiService.findActivity((1..5).random())

        call.enqueue(object : Callback<ActivityResultData> {
            override fun onFailure(call: Call<ActivityResultData>, t: Throwable) {
                displayTextView.text = "Failed to get find results"
            }

            override fun onResponse(call: Call<ActivityResultData>, response: Response<ActivityResultData>) {
                if (response.isSuccessful) {
                    displayTextView.text = "Activity: ${response.body()?.activity}\n\nType: ${response.body()?.type}\n\nParticipants: ${response.body()?.participants}"
                } else {
                    displayTextView.text = "fail"
                }
            }
        })
    }

    private fun getDogResponse() {
        val call = dogApiService.searchImage()

        call.enqueue(object : Callback<DogResultData> {
            override fun onFailure(call: Call<DogResultData>, t: Throwable) {
                displayTextView.text = "Failed to get find results"
            }

            override fun onResponse(call: Call<DogResultData>, response: Response<DogResultData>) {
                if (response.isSuccessful) {
                    displayTextView.text = "Image Url: ${response.body()?.imageUrl}"

                    if(displayTextView.text.isNotBlank()){
                        imageLoader.loadImage(response.body()?.imageUrl.toString(), imageView)
                    }


                } else {
                    displayTextView.text = "fail"
                }
            }
        })
    }
}