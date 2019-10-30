package com.app.koinexample.di

import com.app.koinexample.ui.list.ListViewModel
import com.app.koinexample.ui.splash.SplashViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    viewModel {  SplashViewModel(get(),get()) }
}

val listModule = module {
    viewModel {  ListViewModel(get(),get()) }

}


val activityModules = listOf(splashModule, listModule)

