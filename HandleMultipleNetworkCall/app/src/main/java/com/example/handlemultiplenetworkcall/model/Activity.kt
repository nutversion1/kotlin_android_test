package com.example.handlemultiplenetworkcall.model

import com.squareup.moshi.Json

data class Activity(
    val activity: String,
    @field:Json(name = "type") val activityType: String,
    val participants: String,
)
