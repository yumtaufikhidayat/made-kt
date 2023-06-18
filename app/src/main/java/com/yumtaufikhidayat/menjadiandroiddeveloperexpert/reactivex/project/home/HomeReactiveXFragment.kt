package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.R
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.databinding.FragmentReactiveXHomeBinding
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.data.ResourceReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.ui.ReactiveXViewModelFactory
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.ui.TourismReactiveXAdapter
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.utils.navigateToDetail

class HomeReactiveXFragment : Fragment() {
    private var _binding: FragmentReactiveXHomeBinding? = null
    private val binding get() = _binding!!

    private var homeViewModel: HomeReactiveXViewModel? = null
    private val tourismAdapter by lazy { TourismReactiveXAdapter { navigateToDetail(it) } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReactiveXHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            setHomeAdapter()
            setViewModel()
            setData()
        }
    }

    private fun setHomeAdapter() {
        binding.rvTourism.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tourismAdapter
        }
    }

    private fun setViewModel() {
        val factory = ReactiveXViewModelFactory.getInstance(requireActivity())
        homeViewModel = ViewModelProvider(this, factory)[HomeReactiveXViewModel::class.java]
    }

    private fun setData() {
        homeViewModel?.tourism?.observe(viewLifecycleOwner) {
            binding.apply {
                if (it != null) {
                    when (it) {
                        is ResourceReactiveX.Loading -> showProgressBar(true)
                        is ResourceReactiveX.Success -> {
                            showProgressBar(false)
                            tourismAdapter.submitList(it.data)
                        }
                        is ResourceReactiveX.Error -> {
                            showProgressBar(false)
                            viewError.root.isVisible = true
                            viewError.tvError.text = it.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }
        }
    }

    private fun showProgressBar(isShow: Boolean) {
        binding.progressBar.isVisible = isShow
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}