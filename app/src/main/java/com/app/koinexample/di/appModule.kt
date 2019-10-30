package com.app.koinexample.di

import com.app.koinexample.DispatcherProvider
import com.app.koinexample.KoinApp
import com.app.koinexample.data.AppDataManager
import com.app.koinexample.data.AppPreferenceHelper
import com.app.koinexample.data.DataManager
import com.app.koinexample.data.local.RandomUserDatabase
import com.app.koinexample.data.remote.RandomUserAPI
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module


private val dataModule = module {

    single { RandomUserDatabase.getInMemoryDatabase(androidContext()) }
    single { AppPreferenceHelper.getInstance(androidContext(), "Pref") }
    single { RandomUserAPI.defaultInstance((androidContext() as? KoinApp)?.baseUrl ?: "") }
    factory { DispatcherProvider() }
    single { AppDataManager(get(),get(),get() ) } bind DataManager::class
//    viewModel { SplashViewModel(get(), get()) }


}


val appModules = listOf(dataModule)