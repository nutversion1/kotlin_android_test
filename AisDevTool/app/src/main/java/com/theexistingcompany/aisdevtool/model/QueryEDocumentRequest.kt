package com.theexistingcompany.aisdevtool.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QueryEDocumentRequest(
    @SerializedName("orderType") var orderType: String?,
    @SerializedName("docType") var docType: String?
) : Parcelable
