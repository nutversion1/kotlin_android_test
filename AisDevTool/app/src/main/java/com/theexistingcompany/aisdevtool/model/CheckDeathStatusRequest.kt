package com.theexistingcompany.aisdevtool.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CheckDeathStatusRequest(
    @SerializedName("idCardNo") var idCardNo: String?,
    @SerializedName("birthDate") var birthDate: String?
) : Parcelable
