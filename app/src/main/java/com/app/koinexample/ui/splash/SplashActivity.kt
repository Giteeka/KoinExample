package com.app.koinexample.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.app.koinexample.DispatcherProvider
import com.app.koinexample.R
import com.app.koinexample.ViewModelFactory
import com.app.koinexample.data.AppDataManager
import com.app.koinexample.data.AppPreferenceHelper
import com.app.koinexample.data.local.RandomUserDatabase
import com.app.koinexample.data.remote.RandomUserAPI
import com.app.koinexample.databinding.ActivitySplashBinding
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {
    private val pokemonAPI: RandomUserAPI by inject()
    private val inMemoryDatabase: RandomUserDatabase by inject()
    private val preferenceHelper: AppPreferenceHelper by inject()
    var TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivitySplashBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
//        val pokemonAPI =
//            RandomUserAPI.defaultInstance((application as? KoinApp)?.baseUrl.orEmpty())
//        val inMemoryDatabase = RandomUserDatabase.getInMemoryDatabase(applicationContext)
//        val preferenceHelper = AppPreferenceHelper.getInstance(applicationContext)
        var dataManager = AppDataManager(pokemonAPI, inMemoryDatabase, preferenceHelper)

        var viewModel =
            ViewModelProviders.of(this, ViewModelFactory(dataManager, DispatcherProvider()))
                .get(SplashViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.loadData()
//        viewModel?.state?.observe(this, Observer { state ->
//            Log.e(TAG, "state : $state")
//        })
    }

}
