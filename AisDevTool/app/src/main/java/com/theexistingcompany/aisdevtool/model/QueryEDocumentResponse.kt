package com.theexistingcompany.aisdevtool.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QueryEDocumentResponse(
    @SerializedName("resultCode") var resultCode: String?,
    @SerializedName("resultDescription") var resultDescription: String?,
    @SerializedName("developerMessage") var developerMessage: String?,
    @SerializedName("data") var data: QueryEDocumentData?,
) : Parcelable

@Parcelize
data class QueryEDocumentData(
    @SerializedName("_id") var _id: String?,
    @SerializedName("orderType") var resultDescription: String?,
    @SerializedName("docType") var docType: String?,
    @SerializedName("channel") var channel: String?,
    @SerializedName("docText") var docText: List<QueryEDocumentDocText>,
    @SerializedName("otherComp") var otherComp: String?,
    @SerializedName("otherContent") var otherContent: String?,
) : Parcelable

@Parcelize
data class QueryEDocumentDocText(
    @SerializedName("id") var id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("version") var version: String?,
    @SerializedName("content") var content: String?,
) : Parcelable
