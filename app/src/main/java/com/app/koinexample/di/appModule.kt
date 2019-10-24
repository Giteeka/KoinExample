package com.app.koinexample.di

import com.app.koinexample.BuildConfig
import com.app.koinexample.data.local.RandomUserDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module


private val dataModule = module {

    single { RandomUserDatabase.getInMemoryDatabase(androidContext()) }

    single { get<AppDatabase>().contactDao }

    single<SharedPreferenceManager>()

    single<ContactManager>()

    single<ContactServerManager>()
}


val appModules = listOf(appModule, dataModule)