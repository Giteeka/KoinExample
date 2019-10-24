package com.app.koinexample

import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter


var TAG = "BindingAdapter"
@BindingAdapter("setVisibility")
fun View.setVisibility(show: Boolean?) {
    Log.e(TAG, "setVisibility:show " + show)
    visibility = if (show == true) View.VISIBLE else View.GONE
}

@BindingAdapter("setErrorMessage")
fun AppCompatTextView.setErrorMessage(error: String) {
    Log.e(TAG, "setErrorMessage:error " + error)
    text = error
}

@BindingAdapter("setSuccessMessage")
fun AppCompatTextView.setSuccessMessage(message: String) {
    Log.e(TAG, "setSuccessMessage:message " + message)
    text = message
}