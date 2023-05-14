package br.com.githubusers.ui.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.image(image: String) {
    Glide.with(this)
        .load(image)
        .fitCenter()
        .into(this)
}