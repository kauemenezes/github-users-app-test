package br.com.githubusers.ui.extension

import android.view.View

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}