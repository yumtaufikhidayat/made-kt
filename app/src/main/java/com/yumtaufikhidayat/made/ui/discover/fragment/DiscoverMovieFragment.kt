package com.yumtaufikhidayat.made.ui.discover.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.made.data.NetworkResult
import com.yumtaufikhidayat.made.model.genres.Genre
import com.yumtaufikhidayat.made.ui.discover.adapter.DiscoverMovieAdapter
import com.yumtaufikhidayat.made.ui.discover.viewmodel.DiscoverViewModel
import com.yumtaufikhidayat.made.utils.navigateToDetail
import com.yumtaufikhidayat.made.utils.showError
import com.yumtaufikhidayat.moviesx.databinding.FragmentDiscoverMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscoverMovieFragment : Fragment() {

    private var _binding: FragmentDiscoverMovieBinding? = null
    private val binding get() = _binding!!

    private val discoverViewModel by viewModels<DiscoverViewModel>()
    private var discoverAdapter: DiscoverMovieAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiscoverMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDiscoverMovieToolbar()
        setGenreObserver()
        setDiscoverMovieAdapter()
    }

    private fun setDiscoverMovieToolbar() {
        binding.toolbarDiscoverMovie.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setGenreObserver() {
        discoverViewModel.getGenres().observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Loading -> {}
                is NetworkResult.Success -> setMovieListData(it.data.genres)
                is NetworkResult.Error -> showError(DISCOVER_TAG, it.error)
                is NetworkResult.ServerError -> showError(DISCOVER_TAG, it.error)
                is NetworkResult.Unauthorized -> showError(DISCOVER_TAG, it.error)
            }
        }
    }

    private fun setMovieListData(genreList: List<Genre>) {
        discoverAdapter = DiscoverMovieAdapter(genreList) {
            navigateToDetail(it.id, it.title)
        }

        binding.rvDiscoverMovie.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = discoverAdapter
        }
    }

    private fun setDiscoverMovieAdapter() {
        binding.toolbarDiscoverMovie.etSearch.apply {
            showKeyboard()
            setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    hideKeyboard()
                    return@OnEditorActionListener true
                }
                false
            })

            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {}

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {}

                override fun afterTextChanged(s: Editable?) {
                    showDiscoverData(s)
                }
            })
        }
    }

    private fun showDiscoverData(s: Editable?) {
        discoverViewModel.discoverMovie(s.toString()).observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Loading -> {}
                is NetworkResult.Success -> discoverAdapter?.submitList(it.data.results)
                is NetworkResult.Error -> showError(DISCOVER_TAG, it.error)
                is NetworkResult.ServerError -> showError(DISCOVER_TAG, it.error)
                is NetworkResult.Unauthorized -> showError(DISCOVER_TAG, it.error)
            }
        }
    }


    private fun showKeyboard() {
        binding.toolbarDiscoverMovie.apply {
            etSearch.requestFocus()
            val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(etSearch, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun hideKeyboard() {
        binding.toolbarDiscoverMovie.apply {
            etSearch.clearFocus()
            val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(etSearch.windowToken, 0)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val DISCOVER_TAG = "discover_tag"
    }
}