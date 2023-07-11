package com.yumtaufikhidayat.rickandmortys.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.rickandmortys.databinding.FragmentFavoriteBinding
import com.yumtaufikhidayat.rickandmortys.ui.home.HomeAdapter
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common.navigateToDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private val homeAdapter by lazy { HomeAdapter { navigateToDetail(it) } }
    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFavoriteAdapter()
        setFavoriteData()
    }

    private fun setFavoriteAdapter() {
        binding.rvFavoriteCharacters.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }

    private fun setFavoriteData() {
        viewModel.favoriteCharacter.observe(viewLifecycleOwner) {
            homeAdapter.submitList(it)
            binding.layoutError.root.visibility = if (it.isNotEmpty()) View.GONE else View.VISIBLE
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}