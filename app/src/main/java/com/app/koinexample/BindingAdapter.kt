package com.app.koinexample

import android.text.format.DateFormat
import android.util.Log
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.app.gitrepository.GlideApp
import com.bumptech.glide.request.RequestOptions
import java.util.*


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

@BindingAdapter("setRoundImagePath")
fun AppCompatImageView.setRoundImagePath(path: String?) {
    GlideApp.with(this.context).load(path).apply(RequestOptions.circleCropTransform())
        .placeholder(R.drawable.ic_launcher_background).into(this)
}

@BindingAdapter("setImagePath")
fun AppCompatImageView.setImagePath(path: String?) {
    GlideApp.with(this.context).load(path)
        .placeholder(R.drawable.ic_launcher_background).into(this)
}

@BindingAdapter("setDob")
fun AppCompatTextView.setDob(timestampInString: String?) {
    Log.e(TAG, "dob: " + timestampInString)
    var cal = Calendar.getInstance(Locale.ENGLISH);
    val timestamp = timestampInString?.toLong()
    Log.e(TAG, "dob-time : " + timestamp)
    timestamp?.let {
        cal.timeInMillis = timestamp * 1000L
        var date = DateFormat.format("dd-MM-yyyy", cal).toString()
        text  = date
    }
}
