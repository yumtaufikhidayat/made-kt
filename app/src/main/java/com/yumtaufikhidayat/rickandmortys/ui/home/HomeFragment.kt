package com.yumtaufikhidayat.rickandmortys.ui.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.rickandmortys.R
import com.yumtaufikhidayat.rickandmortys.core.data.Resource
import com.yumtaufikhidayat.rickandmortys.databinding.FragmentHomeBinding
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common.navigateToDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeAdapter by lazy { HomeAdapter { navigateToDetail(it) } }
    private val homeViewModel: HomeViewModel by viewModels()
    private var doubleBackToExitPressedOnce = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            backPressedCallback
        )
        setHomeAdapter()
        setData()
    }

    private val backPressedCallback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (doubleBackToExitPressedOnce) {
                requireActivity().finish()
                return
            }

            doubleBackToExitPressedOnce = true
            Toast.makeText(requireContext(), "Press back again to exit", Toast.LENGTH_SHORT).show()

            Handler(Looper.getMainLooper())
                .postDelayed({
                    doubleBackToExitPressedOnce = false
                }, DELAY_TIME)
        }
    }

    private fun setHomeAdapter() {
        binding.rvCharacters.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }

    private fun setData() {
        homeViewModel.character.observe(viewLifecycleOwner) {
            binding.apply {
                when (it) {
                    is Resource.Loading -> showLoading(true)
                    is Resource.Success -> {
                        showLoading(false)
                        homeAdapter.submitList(it.data)
                    }
                    is Resource.Error -> {
                        showLoading(false)
                        layoutError.root.isVisible = true
                        layoutError.tvErrorDesc.text = it.message ?: getString(R.string.tvSomethingWrong)
                    }
                }
            }
        }
    }

    private fun showLoading(isShow: Boolean) {
        binding.pbLoading.isVisible = isShow
    }

    companion object {
        private const val DELAY_TIME = 2000L
    }
}