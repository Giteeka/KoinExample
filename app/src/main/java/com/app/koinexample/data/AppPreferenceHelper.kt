package com.app.koinexample.data

import android.content.Context
import com.app.koinexample.data.local.Preferences
import com.app.koinexample.data.local.RandomUserDatabase

class AppPreferenceHelper private constructor(
    context: Context,
    name: String
) : Preferences(context, name),
    PreferenceHelper {

    var dataInserted by booleanPref("DATA_INSERTED", false)
    var username by stringPref("USER_NAME", "")
    var email by stringPref("EMAIL", "")
    var password by stringPref("PASSWORD", "")


    companion object {
        private var INSTANCE: AppPreferenceHelper? = null
        fun getInstance(context: Context, name: String): AppPreferenceHelper {
            if (INSTANCE == null)
                INSTANCE = AppPreferenceHelper(context,name)
            return INSTANCE!!
        }
    }

    override fun dataInsertedSuccessFully() {
        dataInserted = true
    }


    override fun isDataInserted(): Boolean {
        return dataInserted ?: false
    }
}