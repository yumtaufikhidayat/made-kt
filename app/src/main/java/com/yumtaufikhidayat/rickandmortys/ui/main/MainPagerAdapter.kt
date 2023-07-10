package com.yumtaufikhidayat.rickandmortys.ui.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yumtaufikhidayat.rickandmortys.ui.favorite.FavoriteFragment
import com.yumtaufikhidayat.rickandmortys.ui.home.HomeFragment

class MainPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    private val listOfFragments = listOf(
        HomeFragment(),
        FavoriteFragment()
    )

    override fun getItemCount(): Int = listOfFragments.size

    override fun createFragment(position: Int): Fragment = listOfFragments[position]
}