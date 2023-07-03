package com.yumtaufikhidayat.made.ui.details.viewmodel

import androidx.lifecycle.ViewModel
import com.yumtaufikhidayat.made.data.repository.MoviesXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: MoviesXRepository
) : ViewModel() {

    fun getDetailMovies(movieId: Int) = repository.getDetailMovie(movieId)

    fun getMovieVideo(movieId: Int) = repository.getMovieVideo(movieId)

    fun getMovieCast(movieId: Int) = repository.getMovieCast(movieId)

    fun getMovieReviews(movieId: Int) = repository.getMovieReviews(movieId)
}