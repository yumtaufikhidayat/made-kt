package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.R
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.databinding.ActivityDetailTourismReactiveXBinding
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.model.TourismReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.ui.ReactiveXViewModelFactory
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.utils.loadImage

class DetailTourismReactiveXActivity : AppCompatActivity() {
    private val binding by lazy { ActivityDetailTourismReactiveXBinding.inflate(layoutInflater) }
    private var detailTourismViewModel: DetailTourismReactiveXViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        getBundleData()
        initViewModel()
    }

    private fun getBundleData() {
        val detailTourism = intent.getParcelableExtra<TourismReactiveX>(EXTRA_DATA)
        showDetailTourism(detailTourism)
    }

    private fun initViewModel() {
        val factory = ReactiveXViewModelFactory.getInstance(this)
        detailTourismViewModel = ViewModelProvider(this, factory)[DetailTourismReactiveXViewModel::class.java]
    }

    private fun showDetailTourism(detailTourism: TourismReactiveX?) {
        binding.apply {
            detailTourism?.let { tourism ->
                supportActionBar?.title = tourism.name
                content.tvDetailDescription.text = tourism.description
                ivDetailImage.loadImage(this@DetailTourismReactiveXActivity, tourism.image)

                var statusFavorite = detailTourism.isFavorite
                setStatusFavorite(statusFavorite)
                fab.setOnClickListener {
                    statusFavorite = !statusFavorite
                    detailTourismViewModel?.setFavoriteTourism(tourism, statusFavorite)
                    setStatusFavorite(statusFavorite)
                }
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        val favoriteIcon = if (statusFavorite) {
            ContextCompat.getDrawable(this, R.drawable.ic_favorite_white)
        } else {
            ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white)
        }

        binding.fab.setImageDrawable(favoriteIcon)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}