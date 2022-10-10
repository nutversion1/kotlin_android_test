package com.theexistingcompany.aisdevtool.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthResponse(
    @SerializedName("resultCode") val resultCode: String?,
    @SerializedName("resultDescription") val resultDescription: String?,
    @SerializedName("developerMessage") val developerMessage: String?,
    @SerializedName("data") val data: Data,
) : Parcelable

@Parcelize
data class Data(
    @SerializedName("token") val token: String?,
) : Parcelable
