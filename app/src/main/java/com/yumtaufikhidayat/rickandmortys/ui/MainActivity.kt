package com.yumtaufikhidayat.rickandmortys.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.yumtaufikhidayat.rickandmortys.R
import com.yumtaufikhidayat.rickandmortys.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setNavHost()
        setUpNavigationDestination()
    }

    private fun setNavHost() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHostFragment.findNavController()
        navController?.let { binding.navBottom.setupWithNavController(it) }
    }

    private fun setUpNavigationDestination() {
        navController?.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.detailFragment -> showHideBottomNavigation(false)
                R.id.splashScreenFragment -> showHideBottomNavigation(false)
                else -> showHideBottomNavigation(true)
            }
        }
    }

    private fun showHideBottomNavigation(isShow: Boolean) {
        binding.navBottom.isVisible = isShow
    }

    override fun onStop() {
        super.onStop()
        navController = null
    }
}