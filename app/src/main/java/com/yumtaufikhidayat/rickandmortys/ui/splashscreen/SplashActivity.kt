package com.yumtaufikhidayat.rickandmortys.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.yumtaufikhidayat.rickandmortys.databinding.ActivitySplashBinding
import com.yumtaufikhidayat.rickandmortys.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        navigateToMain()
    }

    private fun navigateToMain() {
        lifecycleScope.launch {
            delay(2.seconds)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}