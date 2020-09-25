package com.example.sunbelttest.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.setImageFromUrl(url: String, context: Context) {
    Glide.with(context)
        .load(url)
        .override(400, 400)
        .fitCenter()
        .diskCacheStrategy(DiskCacheStrategy.ALL).into(this)
}