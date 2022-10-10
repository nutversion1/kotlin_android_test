package com.theexistingcompany.aisdevtool.model

import com.google.gson.annotations.SerializedName

data class CurrentDateResponse(
    @SerializedName("resultCode") val resultCode: String?,
    @SerializedName("resultDescription") val resultDescription: String?,
    @SerializedName("developerMessage") val developerMessage: String?,
)
