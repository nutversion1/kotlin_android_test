package com.theexistingcompany.aisdevtool.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GetCurrentDateResponse(
    @SerializedName("resultCode") var resultCode: String?,
    @SerializedName("resultDescription") var resultDescription: String?,
    @SerializedName("developerMessage") var developerMessage: String?,
    @SerializedName("data") var data: String?
) : Parcelable