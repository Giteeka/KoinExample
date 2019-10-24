package com.app.koinexample.data


import android.content.Context

interface PreferenceHelper {
    fun isDataInserted() : Boolean
    fun dataInsertedSuccessFully()
}