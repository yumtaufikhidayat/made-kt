package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.databinding.FragmentFavoriteReactiveXBinding
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.ui.ReactiveXViewModelFactory
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.ui.TourismReactiveXAdapter
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.utils.navigateToDetail

class FavoriteReactiveXFragment : Fragment() {
    private var _binding: FragmentFavoriteReactiveXBinding? = null
    private val binding get() = _binding!!

    private var favoriteViewModel: FavoriteReactiveXViewModel? = null
    private val tourismAdapter by lazy { TourismReactiveXAdapter{ navigateToDetail(it) } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteReactiveXBinding.inflate(inflater, container, false)
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
        binding.rvTourism.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = tourismAdapter
        }
    }

    private fun setViewModel() {
        val factory = ReactiveXViewModelFactory.getInstance(requireActivity())
        favoriteViewModel = ViewModelProvider(this, factory)[FavoriteReactiveXViewModel::class.java]
    }

    private fun setData() {
        favoriteViewModel?.favoriteTourism?.observe(viewLifecycleOwner) { dataTourism ->
            tourismAdapter.submitList(dataTourism)
            binding.viewEmpty.root.visibility = if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}