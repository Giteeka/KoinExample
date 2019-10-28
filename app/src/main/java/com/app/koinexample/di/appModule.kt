package com.app.koinexample.di

import com.app.koinexample.DispatcherProvider
import com.app.koinexample.KoinApp
import com.app.koinexample.data.AppDataManager
import com.app.koinexample.data.AppPreferenceHelper
import com.app.koinexample.data.DataManager
import com.app.koinexample.data.local.RandomUserDatabase
import com.app.koinexample.data.remote.RandomUserAPI
import com.app.koinexample.ui.splash.SplashViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import org.koin.experimental.builder.factory
import org.koin.experimental.builder.single


private val dataModule = module {

    single { RandomUserDatabase.getInMemoryDatabase(androidContext()) }
    single { AppPreferenceHelper.getInstance(androidContext(), "Pref") }
    single { RandomUserAPI.defaultInstance((androidContext() as? KoinApp)?.baseUrl ?: "") }
    factory<DispatcherProvider>()
    single<AppDataManager>() bind DataManager::class
//    viewModel { SplashViewModel(get(), get()) }


}


val appModules = listOf(dataModule)