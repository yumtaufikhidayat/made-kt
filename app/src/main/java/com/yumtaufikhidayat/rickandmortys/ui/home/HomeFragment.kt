package com.yumtaufikhidayat.rickandmortys.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yumtaufikhidayat.rickandmortys.R
import com.yumtaufikhidayat.rickandmortys.core.data.Resource
import com.yumtaufikhidayat.rickandmortys.databinding.FragmentHomeBinding
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common.navigateToDetail
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    /*private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!*/

    private val binding by viewBinding<FragmentHomeBinding>()
    private var homeAdapter: HomeAdapter? = null
    private val homeViewModel: HomeViewModel by viewModels()
    private var doubleBackToExitPressedOnce = false

    /*override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }*/

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

            lifecycleScope.launch {
                delay(2.seconds)
                doubleBackToExitPressedOnce = false
            }
        }
    }

    private fun setHomeAdapter() {
        homeAdapter = HomeAdapter {
            navigateToDetail(it)
        }
        binding.apply {
            with(rvCharacters) {
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
                adapter = homeAdapter
            }
        }
    }

    private fun setData() {
        homeViewModel.character.observe(viewLifecycleOwner) {
            binding.apply {
                when (it) {
                    is Resource.Loading -> showLoading(true)
                    is Resource.Success -> {
                        showLoading(false)
                        homeAdapter?.submitList(it.data)
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

    override fun onDestroy() {
        super.onDestroy()
//        _binding = null
        homeAdapter = null
        binding.rvCharacters.adapter = null
        doubleBackToExitPressedOnce = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        _binding = null
        homeAdapter = null
        binding.rvCharacters.adapter = null
        doubleBackToExitPressedOnce = false
    }
}