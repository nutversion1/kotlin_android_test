package com.theexistingcompany.aisdevtool.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AuthResponse(
    @SerializedName("resultCode") val resultCode: String?,
    @SerializedName("resultDescription") val resultDescription: String?,
    @SerializedName("developerMessage") val developerMessage: String?,
    @SerializedName("data") val data: AuthData,
) : Parcelable

@Parcelize
data class AuthData(
    @SerializedName("token") val token: String?,
) : Parcelable
