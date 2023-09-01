package com.example.natifetestapp

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadUrl(context: Context, url: String?, errorDrawable: Int = R.mipmap.ic_launcher){
    val options = RequestOptions()
        .error(errorDrawable)
    Glide.with(context).load(url).apply(options).into(this)
}