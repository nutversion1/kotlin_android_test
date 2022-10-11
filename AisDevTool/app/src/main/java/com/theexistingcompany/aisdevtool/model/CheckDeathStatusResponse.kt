package com.theexistingcompany.aisdevtool.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CheckDeathStatusResponse(
    @SerializedName("resultCode") var resultCode: String?,
    @SerializedName("resultDescription") var resultDescription: String?,
    @SerializedName("developerMessage") var developerMessage: String?,
    @SerializedName("data") var data: CheckDeathResultData?
) : Parcelable


@Parcelize
data class CheckDeathResultData(
    @SerializedName("resultCode") var resultCode: String?,
    @SerializedName("developerMessage") var developerMessage: String?,
    @SerializedName("result") var dataInfo: CheckDeathDataInfo?
) : Parcelable

@Parcelize
data class CheckDeathDataInfo(
    @SerializedName("isError") var isError: Boolean?,
    @SerializedName("dataInfo") var dataInfo: CheckDeathDataStatus?
) : Parcelable

@Parcelize
data class CheckDeathDataStatus(
    @SerializedName("stCode") var stCode: String?,
    @SerializedName("stDesc") var stDesc: String?
) : Parcelable
