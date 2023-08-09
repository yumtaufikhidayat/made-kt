package com.yumtaufikhidayat.rickandmortys.ui.splashscreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.yumtaufikhidayat.rickandmortys.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@AndroidEntryPoint
class SplashScreenFragment : Fragment(R.layout.fragment_splash_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToMain()
    }

    private fun navigateToMain() {
        lifecycleScope.launch {
            delay(2.seconds)
            findNavController().apply {
                popBackStack()
                navigate(R.id.homeFragment)
            }
        }
    }
}