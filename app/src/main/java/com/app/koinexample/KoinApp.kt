package com.app.koinexample

import android.app.Application
import com.app.koinexample.data.AppDataManager
import com.app.koinexample.data.AppPreferenceHelper
import com.app.koinexample.data.DataManager
import com.app.koinexample.data.PreferenceHelper
import com.app.koinexample.data.local.RandomUserDatabase
import com.app.koinexample.data.remote.RandomUserAPI
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class KoinApp : Application() {
    val baseUrl: String
//    get() = "https://randomuser.me/api/1.0/?seed=foobar&results=5"
    get() = "https://randomuser.me/"

    val applicationModule = module {
        single { RandomUserDatabase }
        single { RandomUserAPI }
        single { AppPreferenceHelper }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this,listOf(applicationModule))

    }
}