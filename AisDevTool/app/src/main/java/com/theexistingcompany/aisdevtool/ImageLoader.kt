package com.theexistingcompany.aisdevtool

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(imageUrl: String, imageView: ImageView)
}