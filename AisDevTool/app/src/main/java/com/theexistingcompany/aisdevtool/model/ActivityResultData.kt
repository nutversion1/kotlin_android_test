package com.theexistingcompany.aisdevtool.model

data class ActivityResultData(
    val activity: String,
    val type: String,
    val participants: Int,
    val price: Float,
    val link: String,
    val key: String,
    val accessibility: Float,
)
