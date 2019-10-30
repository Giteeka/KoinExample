package com.app.koinexample.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.app.koinexample.R
import com.app.koinexample.databinding.ActivitySplashBinding
import com.app.koinexample.ui.main.MainActivity
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by inject()

    private var TAG = "SplashActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding: ActivitySplashBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)
        binding.lifecycleOwner = this

        splashViewModel.loadData()

        splashViewModel.showData.observe(this, Observer {
            if (it == true) {
                binding.progressCircular.postDelayed(
                    {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }, 500L
                )
            }
        })
    }

}
