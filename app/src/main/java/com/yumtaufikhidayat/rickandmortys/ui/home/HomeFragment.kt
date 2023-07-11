package com.yumtaufikhidayat.rickandmortys.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeAdapter by lazy { HomeAdapter { navigateToDetail(it) } }
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHomeAdapter()
        setData()
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

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}