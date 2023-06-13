package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.R
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.utils.showToast
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.favorite.FavoriteFragment
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.home.HomeFragment
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.databinding.ActivityTourismBinding

class TourismActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val binding by lazy { ActivityTourismBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        setUi(savedInstanceState)
    }

    private fun setUi(savedInstanceState: Bundle?) {
        binding.apply {
            val toggle = ActionBarDrawerToggle(
                this@TourismActivity,
                drawerLayout,
                appBarMain.toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            navView.setNavigationItemSelectedListener(this@TourismActivity)

            if (savedInstanceState == null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, HomeFragment())
                    .commit()
                supportActionBar?.title = getString(R.string.menu_home)
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        binding.apply {
            var fragment: Fragment? = null
            var title = getString(R.string.app_name)
            when (item.itemId) {
                R.id.nav_home -> {
                    fragment = HomeFragment()
                    title = getString(R.string.menu_home)
                }
                R.id.nav_favorite -> {
                    fragment = FavoriteFragment()
                    title = getString(R.string.menu_favorite)
                }
                R.id.nav_map -> showToast(this@TourismActivity, "Coming Soon")
            }

            if (fragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            supportActionBar?.title = title

            drawerLayout.closeDrawer(GravityCompat.START)
        }
        return true
    }
}