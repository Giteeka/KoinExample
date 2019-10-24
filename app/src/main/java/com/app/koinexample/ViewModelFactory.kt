package com.app.koinexample

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.app.koinexample.data.AppDataManager
import com.app.koinexample.data.DataManager
import com.app.koinexample.data.local.RandomUserDatabase
import com.app.koinexample.data.remote.RandomUserAPI
import com.app.koinexample.ui.splash.SplashViewModel

class ViewModelFactory(var dataManager: DataManager, var dispatcherProvider: DispatcherProvider) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(SplashViewModel::class.java) ->
                SplashViewModel(dataManager, dispatcherProvider) as T
            else ->
                throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }


}