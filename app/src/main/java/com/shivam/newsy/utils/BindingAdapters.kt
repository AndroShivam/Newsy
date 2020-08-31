package com.shivam.newsy.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("isGone")
fun isGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}

@BindingAdapter("visibleUnless")
fun View.visibleUnless(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.INVISIBLE
}

@BindingAdapter("loadImage")
fun ImageView.loadImage(url: String?) {
    url?.let {
        Glide.with(context).load(it)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
}
