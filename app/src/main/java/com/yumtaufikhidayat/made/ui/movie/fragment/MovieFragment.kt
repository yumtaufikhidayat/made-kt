package com.yumtaufikhidayat.made.ui.movie.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.made.data.NetworkResult
import com.yumtaufikhidayat.made.model.genres.Genre
import com.yumtaufikhidayat.made.ui.movie.adapter.LoadMoreAdapter
import com.yumtaufikhidayat.made.ui.movie.adapter.MovieAdapter
import com.yumtaufikhidayat.made.ui.movie.viewmodel.HomeViewModel
import com.yumtaufikhidayat.made.utils.navigateToDetail
import com.yumtaufikhidayat.made.utils.showError
import com.yumtaufikhidayat.moviesx.R
import com.yumtaufikhidayat.moviesx.databinding.FragmentMovieBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MovieFragment : Fragment() {

    private var _binding: FragmentMovieBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by viewModels<HomeViewModel>()
    private var movieAdapter: MovieAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setMovieListAdapter()
        setObserver()
        navigateToSearch()
    }

    private fun setMovieListAdapter() {
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }

    private fun setObserver() {
        homeViewModel.getGenres().observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Loading -> {}
                is NetworkResult.Success -> setMovieListData(it.data.genres)
                is NetworkResult.Error -> showError(HOME_TAG, it.error)
                is NetworkResult.ServerError -> showError(HOME_TAG, it.error)
                is NetworkResult.Unauthorized -> showError(HOME_TAG, it.error)
            }
        }
    }

    private fun setMovieListData(genreList: List<Genre>) {
        binding.apply {
            movieAdapter = MovieAdapter(genreList) {
                navigateToDetail(it.id, it.title)
            }

            lifecycleScope.launch {
                homeViewModel.getMovieNowPlaying().collect {
                    movieAdapter?.submitData(viewLifecycleOwner.lifecycle, it)
                }
            }

            movieAdapter?.apply {
                layoutError.apply {
                    addLoadStateListener { loadState ->
                        val loadStateRefresh = loadState.source.refresh
                        shimmerLoading.isVisible = loadStateRefresh is LoadState.Loading
                        rvHome.isVisible = loadStateRefresh is LoadState.NotLoading
                        tvErrorTitle.apply {
                            isVisible = loadStateRefresh is LoadState.Error
                            text = getString(R.string.tvOops)
                            setTextColor(
                                ContextCompat.getColor(
                                    requireContext(),
                                    R.color.colorOrange
                                )
                            )
                        }
                        tvError.apply {
                            isVisible = loadStateRefresh is LoadState.Error
                            text = getString(R.string.tvUnableLoadData)
                            setTextColor(
                                ContextCompat.getColor(
                                    requireContext(),
                                    R.color.colorOrange
                                )
                            )
                        }
                        btnRetry.isVisible = loadStateRefresh is LoadState.Error

                        if (loadStateRefresh is LoadState.NotLoading
                            && loadState.append.endOfPaginationReached
                            && itemCount < 1
                        ) {
                            rvHome.isVisible = false
                            tvErrorTitle.isVisible = true
                            tvError.isVisible = true
                        } else {
                            tvErrorTitle.isVisible = false
                            tvError.isVisible = false
                        }
                    }

                    btnRetry.setOnClickListener {
                        movieAdapter?.retry()
                    }
                }
            }

            rvHome.adapter = movieAdapter?.withLoadStateHeaderAndFooter(
                header = LoadMoreAdapter { movieAdapter?.retry() },
                footer = LoadMoreAdapter { movieAdapter?.retry() }
            )
        }
    }

    private fun navigateToSearch() {
        binding.fabSearch.setOnClickListener {
            findNavController().navigate(R.id.discoverMovieFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val HOME_TAG = "home_tag"
    }
}