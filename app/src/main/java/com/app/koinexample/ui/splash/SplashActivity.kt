package com.app.koinexample.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.koinexample.R
import com.app.koinexample.databinding.ActivitySplashBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {
    //    private val pokemonAPI: RandomUserAPI by inject()
//    private val inMemoryDatabase: RandomUserDatabase by inject()
//    private val preferenceHelper: AppPreferenceHelper by inject()
//    private val dataManager: AppDataManager by inject()
//    private val dispatcherProvider: DispatcherProvider by inject()
    private val splashViewModel : SplashViewModel by inject()
    private var TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivitySplashBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this
//        val pokemonAPI =
//            RandomUserAPI.defaultInstance((application as? KoinApp)?.baseUrl.orEmpty())
//        val inMemoryDatabase = RandomUserDatabase.getInMemoryDatabase(applicationContext)
//        val preferenceHelper = AppPreferenceHelper.getInstance(applicationContext)
//        var dataManager = dataManager

//        var viewModel =
//            ViewModelProviders.of(this, ViewModelFactory(dataManager, dispatcherProvider))
//                .get(SplashViewModel::class.java)
        binding.viewModel = splashViewModel
        splashViewModel.loadData()
//        viewModel?.state?.observe(this, Observer { state ->
//            Log.e(TAG, "state : $state")
//        })
    }

}
