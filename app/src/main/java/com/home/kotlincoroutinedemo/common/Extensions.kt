package com.home.kotlincoroutinedemo.common

import android.content.Context
import android.os.Build
import android.text.Html
import android.text.Spanned
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun View.setGone() {
    this.visibility = View.GONE
}

fun Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) =
    this?.let { Toast.makeText(it, text, duration).show() }