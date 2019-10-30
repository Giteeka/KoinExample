package com.app.koinexample

import android.app.Application
import com.app.koinexample.di.activityModules
import com.app.koinexample.di.appModules
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class KoinApp : Application() {
    val baseUrl: String
        //    get() = "https://randomuser.me/api/1.0/?seed=foobar&results=5"
        get() = "https://randomuser.me/"

//    val applicationModule = module {
//        single { RandomUserDatabase }
//        single { RandomUserAPI }
//        single { AppPreferenceHelper }
//    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG),
            this,
            appModules + activityModules
        }
    }
}