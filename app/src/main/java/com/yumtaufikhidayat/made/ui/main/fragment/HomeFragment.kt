package com.yumtaufikhidayat.made.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.yumtaufikhidayat.made.ui.main.adapter.HomePagerAdapter
import com.yumtaufikhidayat.moviesx.R
import com.yumtaufikhidayat.moviesx.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setToolbarName()
        setTabLayout()
    }

    private fun setToolbarName() {
        binding.toolbarMovie.tvToolbar.text = getString(R.string.app_name)
    }

    private fun setTabLayout() {
        binding.apply {
            val homePagerAdapter = HomePagerAdapter(this@HomeFragment)
            viewPagerHome.adapter = homePagerAdapter
            TabLayoutMediator(tabLayoutHome, viewPagerHome) { tabs, position ->
                tabs.text = getString(tabsTitle[position])
            }.attach()
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        @StringRes
        private val tabsTitle = intArrayOf(
            R.string.tvMovies,
            R.string.tvFavorites
        )
    }
}