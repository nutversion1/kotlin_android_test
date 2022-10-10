package com.theexistingcompany.aisdevtool

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.theexistingcompany.aisdevtool.api.EasyAppService
import com.theexistingcompany.aisdevtool.model.AuthRequest
import com.theexistingcompany.aisdevtool.model.AuthResponse
import com.theexistingcompany.aisdevtool.viewmodel.MainActivityViewModel
import okhttp3.OkHttpClient
import okhttp3.Request
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {
    private val imageView by lazy{ findViewById<ImageView>(R.id.imageView) }
    private val displayTextView by lazy{ findViewById<TextView>(R.id.displayTextView) }
    private val button by lazy{ findViewById<TextView>(R.id.button) }

    private val mainActivityViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            mainActivityViewModel.let {
                it.logInSuccess.observe(this, logInSuccessObserver)
                it.loginFailure.observe(this, logInFailureObserver)
                it.loginLoading.observe(this, logInLoadingObserver)
            }

            mainActivityViewModel.logIn("jaruwann", "0")
        }
    }

    private val logInSuccessObserver = Observer<AuthResponse?> {
        Log.d("myDebug", "success: $it")
        displayTextView.text = "success: $it"
    }

    private val logInFailureObserver = Observer<String?> {
        Log.d("myDebug", "fail")
        displayTextView.text = "fail: $it"
    }

    private val logInLoadingObserver = Observer<Unit> {
        Log.d("myDebug", "loading")
        displayTextView.text = "loading..."
    }
}