package com.yumtaufikhidayat.made.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.made.model.genres.Genre
import com.yumtaufikhidayat.made.model.main.MovieMainResult
import com.yumtaufikhidayat.made.utils.Constant
import com.yumtaufikhidayat.made.utils.convertDate
import com.yumtaufikhidayat.made.utils.loadImage
import com.yumtaufikhidayat.made.utils.toRating
import com.yumtaufikhidayat.moviesx.R
import com.yumtaufikhidayat.moviesx.databinding.ItemMoviesBinding

class MovieAdapter(
    private val genres: List<Genre>,
    private val onItemClickListener: (MovieMainResult) -> Unit
) : PagingDataAdapter<MovieMainResult, MovieAdapter.ViewHolder>(movieDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null) holder.bind(data)
    }

    inner class ViewHolder(private val binding: ItemMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MovieMainResult) {
            binding.apply {
                imgPoster.loadImage(data.posterPath)
                tvTitle.text = data.title
                tvReleasedOn.text = root.context.getString(
                    R.string.tvReleasedOn, data.releaseDate?.convertDate(
                        Constant.YYYY_MM_DD_FORMAT,
                        Constant.EEE_D_MMM_YYYY_FORMAT
                    ) ?: root.context.getString(R.string.tvNA)
                )
                tvRating.text = root.context.getString(
                    R.string.tvRatingAverageCount,
                    toRating(data.voteAverage),
                    "${data.voteCount}"
                )

                val genre = mutableListOf<String>()
                data.genreIds.forEach { id ->
                    val genreTemp = genres.filter {
                        it.id == id
                    }
                    if (genreTemp.isNotEmpty()) {
                        genre.add(genreTemp.first().name)
                    }
                }

                tvGenres.text = genre.toString()
                    .replace("[", "")
                    .replace("]", "")

                itemView.setOnClickListener {
                    onItemClickListener(data)
                }
            }
        }
    }

    companion object {
        val movieDiffCallback = object : ItemCallback<MovieMainResult>() {
            override fun areItemsTheSame(
                oldItem: MovieMainResult,
                newItem: MovieMainResult
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MovieMainResult,
                newItem: MovieMainResult
            ): Boolean = oldItem == newItem
        }
    }
}