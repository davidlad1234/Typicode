package com.jpmorgan.typicode.utils

import android.content.Context
import android.widget.ImageView

import com.squareup.picasso.Picasso

object FMViewUtils {
    fun loadImage(context: Context, imageView: ImageView, url: String?) {

        if (url != null && !url.isEmpty()) {
            val picasso = Picasso.with(context)
            picasso.load(url).centerCrop().fit().into(imageView)
        }
    }


}
