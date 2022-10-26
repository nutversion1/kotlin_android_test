package com.theexistingcompany.aisdevtool

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.theexistingcompany.aisdevtool.model.*
import com.theexistingcompany.aisdevtool.viewmodel.MainActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


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

                it.checkDeathStatusSuccess.observe(this, checkDeathStatusSuccessObserver)
                it.checkDeathStatusFailure.observe(this, checkDeathStatusFailureObserver)
                it.checkDeathStatusLoading.observe(this, checkDeathStatusLoadingObserver)

                it.getCurrentDateSuccess.observe(this, getCurrentDateSuccessObserver)
                it.getCurrentDateFailure.observe(this, getCurrentDateFailureObserver)
                it.getCurrentDateLoading.observe(this, getCurrentDateLoadingObserver)

                it.queryEDocumentTCSuccess.observe(this, queryEDocumentTCSuccessObserver)
                it.queryEDocumentTCFailure.observe(this, queryEDocumentTCFailureObserver)
                it.queryEDocumentTCLoading.observe(this, queryEDocumentTCLoadingObserver)

                it.queryEDocumentConsentSuccess.observe(this, queryEDocumentConsentSuccessObserver)
                it.queryEDocumentConsentFailure.observe(this, queryEDocumentConsentFailureObserver)
                it.queryEDocumentConsentLoading.observe(this, queryEDocumentConsentLoadingObserver)
            }

            mainActivityViewModel.logIn("jaruwann", "0")
//            mainActivityViewModel.checkDeathStatus("1100701208535", "25330715")
//            mainActivityViewModel.getCurrentDate()
            mainActivityViewModel.queryEDocumentTC()
            mainActivityViewModel.queryEDocumentConsent()
        }
    }

    /////////////////////////////

    private val logInSuccessObserver = Observer<AuthResponse?> {
        Log.d("myDebug", "success: $it")
        displayTextView.text = "success: $it"
    }

    private val logInFailureObserver = Observer<String?> {
        Log.d("myDebug", "fail: $it")
        displayTextView.text = "fail: $it"
    }

    private val logInLoadingObserver = Observer<Unit> {
        Log.d("myDebug", "loading 1")
        displayTextView.text = "loading..."
    }

    /////////////////////////////

    private val checkDeathStatusSuccessObserver = Observer<CheckDeathStatusResponse?> {
        Log.d("myDebug", "success: $it")

    }

    private val checkDeathStatusFailureObserver = Observer<String?> {
        Log.d("myDebug", "fail: $it")

    }

    private val checkDeathStatusLoadingObserver = Observer<Unit> {
        Log.d("myDebug", "loading 2")

    }

    /////////////////////////////

    private val getCurrentDateSuccessObserver = Observer<GetCurrentDateResponse?> {
        Log.d("myDebug", "success: $it")

    }

    private val getCurrentDateFailureObserver = Observer<String?> {
        Log.d("myDebug", "fail: $it")

    }

    private val getCurrentDateLoadingObserver = Observer<Unit> {
        Log.d("myDebug", "loading 3")

    }

    /////////////////////////////

    private val queryEDocumentTCSuccessObserver = Observer<QueryEDocumentResponse?> {

        Log.d("myDebug", "success: $it")

    }

    private val queryEDocumentTCFailureObserver = Observer<String?> {
        Log.d("myDebug", "fail: $it")

    }

    private val queryEDocumentTCLoadingObserver = Observer<Unit> {
        Log.d("myDebug", "loading 4")

    }

    /////////////////////////////

    private val queryEDocumentConsentSuccessObserver = Observer<QueryEDocumentResponse?> {

        Log.d("myDebug", "success: $it")

    }

    private val queryEDocumentConsentFailureObserver = Observer<String?> {
        Log.d("myDebug", "fail: $it")

    }

    private val queryEDocumentConsentLoadingObserver = Observer<Unit> {
        Log.d("myDebug", "loading 5")

    }
}