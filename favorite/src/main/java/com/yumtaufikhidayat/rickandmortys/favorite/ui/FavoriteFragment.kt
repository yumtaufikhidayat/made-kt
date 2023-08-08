package com.yumtaufikhidayat.rickandmortys.favorite.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.rickandmortys.favorite.R
import com.yumtaufikhidayat.rickandmortys.favorite.databinding.FragmentFavoriteBinding
import com.yumtaufikhidayat.rickandmortys.favorite.inject
import com.yumtaufikhidayat.rickandmortys.favorite.ui.factory.ViewModelFactory
import com.yumtaufikhidayat.rickandmortys.ui.home.HomeAdapter
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common.navigateToDetail
import javax.inject.Inject

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel by viewModels<FavoriteViewModel> {
        factory
    }

    private var homeAdapter: HomeAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

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
        homeAdapter = HomeAdapter {
            navigateToDetail(it)
        }
        binding.rvFavoriteCharacters.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }

    private fun setFavoriteData() {
        viewModel.favoriteCharacter.observe(viewLifecycleOwner) {
            homeAdapter?.submitList(it)
            binding.layoutError.apply {
                if (it.isNotEmpty()) {
                    showError(true, "")
                } else {
                    showError(false, getString(R.string.tvEmptyFavorite))
                }
            }
        }
    }

    private fun showError(isVisible: Boolean, message: String) {
        binding.layoutError.apply {
            root.visibility = if (isVisible) View.GONE else View.VISIBLE
            tvErrorDesc.text = message
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        homeAdapter = null
    }
}