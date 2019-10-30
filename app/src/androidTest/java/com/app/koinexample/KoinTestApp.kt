package com.app.koinexample

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module
import org.koin.standalone.StandAloneContext.loadKoinModules

class KoinTestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this@KoinTestApp, emptyList())
    }

    internal fun injectModule(module : Module){
        loadKoinModules(module)
    }
}