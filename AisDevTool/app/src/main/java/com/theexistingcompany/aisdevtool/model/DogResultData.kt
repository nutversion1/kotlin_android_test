package com.theexistingcompany.aisdevtool.model

import com.squareup.moshi.Json

data class DogResultData (
    @field:Json(name = "message") val imageUrl: String,
    val status: String,
)
