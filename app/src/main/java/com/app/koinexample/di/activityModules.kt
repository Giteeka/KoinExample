package com.app.koinexample.di

import com.app.koinexample.ui.splash.SplashViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val splashModule = module {

    viewModel<SplashViewModel>()
}


val activityModules = listOf(splashModule)

