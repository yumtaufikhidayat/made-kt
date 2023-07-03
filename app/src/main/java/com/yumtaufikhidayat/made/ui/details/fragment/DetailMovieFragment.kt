package com.yumtaufikhidayat.made.ui.details.fragment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.yumtaufikhidayat.made.data.NetworkResult
import com.yumtaufikhidayat.made.model.cast.Cast
import com.yumtaufikhidayat.made.model.detail.MovieDetailResponse
import com.yumtaufikhidayat.made.model.movietrailer.TrailerResult
import com.yumtaufikhidayat.made.model.reviews.ReviewsResult
import com.yumtaufikhidayat.made.ui.details.adapter.MovieCastAdapter
import com.yumtaufikhidayat.made.ui.details.adapter.MovieReviewsAdapter
import com.yumtaufikhidayat.made.ui.details.adapter.MovieTrailerVideoAdapter
import com.yumtaufikhidayat.made.ui.details.viewmodel.DetailsViewModel
import com.yumtaufikhidayat.made.utils.Constant
import com.yumtaufikhidayat.made.utils.convertDate
import com.yumtaufikhidayat.made.utils.loadImage
import com.yumtaufikhidayat.made.utils.showToast
import com.yumtaufikhidayat.made.utils.toRating
import com.yumtaufikhidayat.moviesx.R
import com.yumtaufikhidayat.moviesx.databinding.FragmentDetailMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailMovieFragment : Fragment() {

    private var _binding: FragmentDetailMovieBinding? = null
    private val binding get() = _binding!!

    private val detailsViewModel by viewModels<DetailsViewModel>()
    private val castAdapter by lazy { MovieCastAdapter() }
    private val trailerVideoAdapter by lazy { MovieTrailerVideoAdapter() }
    private val reviewsAdapter by lazy { MovieReviewsAdapter() }

    private var idMovie = 0
    private var title = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBundleData()
        showToolbarData()
        setDetailMovieObserver()
        setCastAdapter()
        setCastObserver(idMovie)
        setTrailerVideoAdapter()
        setTrailerVideoObserver(idMovie)
        setReviewsAdapter()
        setReviewsObserver(idMovie)
        setReadMore()
    }

    private fun getBundleData() {
        idMovie = arguments?.getInt(EXTRA_ID, 0) ?: 0
        title = arguments?.getString(EXTRA_TITLE, "").orEmpty()
    }

    private fun showToolbarData() {
        binding.toolbarDetailMovie.apply {
            tvToolbar.text = title
            imgBack.isVisible = true
            imgBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setDetailMovieObserver() {
        detailsViewModel.getDetailMovies(idMovie).observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Loading -> {
                    showLayoutError(false, "")
                    showLoading(true)
                }
                is NetworkResult.Success -> {
                    showLayoutError(false, "")
                    showLoading(false)
                    setDetailData(it.data)
                }
                is NetworkResult.Error -> {
                    showLoading(false)
                    showLayoutError(true, it.error)
                }
                is NetworkResult.ServerError -> {
                    showLoading(false)
                    showLayoutError(true, it.error)
                }
                is NetworkResult.Unauthorized -> {
                    showLoading(false)
                    showLayoutError(true, it.error)
                }
            }
        }
    }

    private fun setDetailData(data: MovieDetailResponse) {
        binding.apply {
            imgPoster.loadImage(data.posterPath.orEmpty())
            imgBackdrop.loadImage(data.backdropPath)
            tvTitle.text = data.title

            val releasedDate = data.releaseDate.convertDate(
                Constant.YYYY_MM_DD_FORMAT,
                Constant.EEE_D_MMM_YYYY_FORMAT
            )
            tvReleasedOn.text = getString(
                R.string.tvReleasedOn,
                releasedDate
            )
            tvStatus.text = data.status

            when {
                data.overview.isEmpty() -> {
                    tvOverview.isVisible = false
                    tvNoOverview.isVisible = true
                    tvReadMore.isVisible = false
                }

                else -> {
                    tvNoOverview.isVisible = false
                    tvOverview.apply {
                        isVisible = true
                        text = data.overview
                    }
                }
            }

            when {
                data.voteAverage.toString().isEmpty() -> tvRating.text = getString(R.string.tvNA)
                else -> tvRating.text = toRating(data.voteAverage)
            }

            when {
                data.originalLanguage.isEmpty() -> tvLanguage.text = getString(R.string.tvNA)
                else -> tvLanguage.text =
                    if (data.spokenLanguages.isNotEmpty()) {
                        data.spokenLanguages.first().englishName
                    } else {
                        data.originalLanguage
                    }
            }

            when {
                data.productionCountries.isEmpty() -> tvCountry.text = getString(R.string.tvNA)
                else -> tvCountry.text = data.productionCountries.joinToString { countries -> countries.iso31661 }
            }

            when {
                data.runtime.toString().isEmpty() -> tvRuntime.text = getString(R.string.tvNA)
                else -> tvRuntime.text = convertRuntime(data.runtime)
            }

            when {
                data.movieDetailGenres.isEmpty() -> showNoGenres(true)
                else -> {
                    showNoGenres(false)
                    tvGenre.text = data.movieDetailGenres.joinToString { genre -> genre.name }
                }
            }

            shareMovie(data.homepage)
        }
    }

    private fun setReadMore() {
        binding.apply {
            tvReadMore.isVisible = true
            tvReadMore.setOnClickListener {
                if (tvReadMore.text.toString() == getString(R.string.tvReadMore)) {
                    tvOverview.maxLines = Integer.MAX_VALUE
                    tvOverview.ellipsize = null
                    tvReadMore.text = getString(R.string.tvReadLess)
                } else {
                    tvOverview.maxLines = 4
                    tvOverview.ellipsize = TextUtils.TruncateAt.END
                    tvReadMore.text = getString(R.string.tvReadMore)
                }
            }
        }
    }

    private fun shareMovie(url: String) {
        binding.toolbarDetailMovie.apply {
            imgShare.isVisible = true
            imgShare.setOnClickListener {
                try {
                    val body = getString(R.string.tvVisitMovie, url)
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, body)
                    }
                    startActivity(
                        Intent.createChooser(
                            shareIntent,
                            getString(R.string.tvShareWith)
                        )
                    )
                } catch (e: Exception) {
                    showToast(requireContext(), getString(R.string.tvOops))
                }
            }
        }
    }

    private fun setCastAdapter() {
        binding.rvMovieCast.apply {
            val helper: SnapHelper = LinearSnapHelper()
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            helper.attachToRecyclerView(this)
            setHasFixedSize(true)
            adapter = castAdapter
        }
    }

    private fun setCastObserver(idMovie: Int) {
        detailsViewModel.getMovieCast(idMovie).observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Loading -> showNoCast(false)
                is NetworkResult.Success -> setCastData(it.data.cast)
                is NetworkResult.Error -> showNoCast(false)
                is NetworkResult.ServerError -> showNoCast(false)
                is NetworkResult.Unauthorized -> showNoCast(false)
            }
        }
    }

    private fun setCastData(cast: List<Cast>) {
        if (cast.isEmpty()) {
            showNoCast(true)
        } else {
            showNoCast(false)
            castAdapter.submitList(cast)
        }
    }

    private fun setTrailerVideoAdapter() {
        binding.rvTrailerVideo.apply {
            val helper: SnapHelper = LinearSnapHelper()
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            helper.attachToRecyclerView(this)
            setHasFixedSize(true)
            adapter = trailerVideoAdapter
        }
    }

    private fun setTrailerVideoObserver(idMovie: Int) {
        detailsViewModel.getMovieVideo(idMovie).observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Loading -> showVideo(false)
                is NetworkResult.Error -> showVideo(false)
                is NetworkResult.Success -> setMovieVideoTrailer(it.data.results)
                is NetworkResult.ServerError -> showVideo(false)
                is NetworkResult.Unauthorized -> showVideo(false)
            }
        }
    }

    private fun setMovieVideoTrailer(results: List<TrailerResult>) {
        if (results.isEmpty()) {
            showVideo(false)
        } else {
            showVideo(true)
            trailerVideoAdapter.submitList(results)
        }
    }

    private fun setReviewsAdapter() {
        binding.rvMovieReviews.apply {
            val helper: SnapHelper = LinearSnapHelper()
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            helper.attachToRecyclerView(this)
            setHasFixedSize(true)
            adapter = reviewsAdapter
        }
    }

    private fun setReviewsObserver(idMovie: Int) {
        detailsViewModel.getMovieReviews(idMovie).observe(viewLifecycleOwner) {
            when (it) {
                is NetworkResult.Loading -> showNoReviews(false)
                is NetworkResult.Success -> setReviewsData(it.data.results)
                is NetworkResult.Error -> showNoReviews(false)
                is NetworkResult.ServerError -> showNoReviews(false)
                is NetworkResult.Unauthorized -> showNoReviews(false)
            }
        }
    }

    private fun setReviewsData(reviewsResults: List<ReviewsResult>) {
        if (reviewsResults.isEmpty()) {
            showNoReviews(true)
        } else {
            showNoReviews(false)
            reviewsAdapter.submitList(reviewsResults)
        }
    }

    private fun showNoGenres(isShow: Boolean) = binding.tvNoGenres.isVisible == isShow

    private fun showNoCast(isShow: Boolean) = binding.tvNoCast.isVisible == isShow

    private fun showNoReviews(isShow: Boolean) = binding.tvNoReviews.isVisible == isShow

    private fun showVideo(isShow: Boolean) {
        binding.apply {
            if (isShow) {
                rvTrailerVideo.isVisible = true
                tvNoVideo.isVisible = false
            } else {
                rvTrailerVideo.isVisible = false
                tvNoVideo.isVisible = true
            }
        }
    }

    private fun showLayoutError(isShow: Boolean, message: String) {
        binding.apply {
            if (isShow) {
                layoutErrorGroup.apply {
                    visibility = View.VISIBLE
                    layoutError.apply {
                        tvErrorTitle.visibility = View.VISIBLE
                        tvErrorTitle.text = getString(R.string.tvOops)

                        tvError.visibility = View.VISIBLE
                        tvError.text = message

                        btnRetry.visibility = View.VISIBLE
                        btnRetry.setOnClickListener {
                            setDetailMovieObserver()
                            setCastObserver(idMovie)
                            setTrailerVideoObserver(idMovie)
                            setReviewsObserver(idMovie)
                        }
                    }
                }
            } else {
                layoutErrorGroup.visibility = View.GONE
            }
        }
    }

    private fun showLoading(isShow: Boolean) {
        binding.apply {
            if (isShow) {
                shimmerLoadingDetailMovie.visibility = View.VISIBLE
                layoutDetailGroup.visibility = View.GONE
            } else {
                shimmerLoadingDetailMovie.visibility = View.GONE
                layoutDetailGroup.visibility = View.VISIBLE
            }
        }
    }

    private fun convertRuntime(data: Int): String {
        val hours = data / TIME_60
        val minutes = data % TIME_60
        return getString(R.string.tvRuntimeInTime, hours, minutes)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val EXTRA_ID = "EXTRA_ID"
        const val EXTRA_TITLE = "EXTRA_TITLE"
        const val TIME_60 = 60
    }
}