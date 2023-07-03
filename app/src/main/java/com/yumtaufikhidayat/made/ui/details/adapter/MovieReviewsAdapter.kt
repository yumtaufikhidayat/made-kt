package com.yumtaufikhidayat.made.ui.details.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.made.model.reviews.ReviewsResult
import com.yumtaufikhidayat.made.utils.Constant
import com.yumtaufikhidayat.made.utils.convertDate
import com.yumtaufikhidayat.made.utils.loadImage
import com.yumtaufikhidayat.moviesx.databinding.ItemReviewsBinding

class MovieReviewsAdapter: ListAdapter<ReviewsResult, MovieReviewsAdapter.ViewHolder>(reviewsDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemReviewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemReviewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(data: ReviewsResult) {
                binding.apply {
                    val author = data.authorDetails
                    imgReviewer.loadImage(author.avatarPath)
                    tvReviewerName.text = data.author
                    tvReviewerRating.text = String.format("%s%s", author.rating.toString(), "/10")
                    tvReviewerDate.text = data.updatedAt.convertDate(
                        Constant.FULL_FORMAT,
                        Constant.EEE_D_MMM_YYYY_FORMAT
                    )
                    tvReviewerReview.text = data.content
                    cardReview.setOnClickListener {
                        try {
                            val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(data.url))
                            it.context.startActivity(Intent.createChooser(intentBrowser, "Open with:"))
                        } catch (_: Exception) { }
                    }
                }
            }
    }

    companion object {
        val reviewsDiffCallback = object : DiffUtil.ItemCallback<ReviewsResult>() {
            override fun areItemsTheSame(
                oldItem: ReviewsResult,
                newItem: ReviewsResult
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ReviewsResult,
                newItem: ReviewsResult
            ): Boolean = oldItem == newItem
        }
    }
}