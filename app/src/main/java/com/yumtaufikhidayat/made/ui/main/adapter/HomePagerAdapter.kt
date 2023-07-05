package com.yumtaufikhidayat.made.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.yumtaufikhidayat.made.ui.favorite.fragment.FavoriteFragment
import com.yumtaufikhidayat.made.ui.movie.fragment.MovieFragment

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val listOfFragments = listOf(
        MovieFragment(),
        FavoriteFragment()
    )

    override fun createFragment(position: Int): Fragment = listOfFragments[position]

    override fun getItemCount(): Int = listOfFragments.size
}