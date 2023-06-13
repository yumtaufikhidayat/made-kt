package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.ui.TourismAdapter
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.ui.ViewModelFactory
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.utils.navigateToDetail
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private var favoriteViewModel: FavoriteViewModel? = null
    private var tourismAdapter: TourismAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            setTourismAdapter()
            setViewModel()
            setData()
        }
    }

    private fun setTourismAdapter() {
        tourismAdapter = TourismAdapter {
            navigateToDetail(it)
        }

        binding.rvTourism.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tourismAdapter
        }
    }

    private fun setViewModel() {
        val factory = ViewModelFactory.getInstance(requireActivity())
        favoriteViewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]
    }

    private fun setData() {
        favoriteViewModel?.favoriteTourism?.observe(viewLifecycleOwner) { dataTourism ->
            tourismAdapter?.submitList(dataTourism)
            binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}