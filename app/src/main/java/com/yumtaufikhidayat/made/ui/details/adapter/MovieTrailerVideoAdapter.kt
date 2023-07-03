package com.yumtaufikhidayat.made.ui.details.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.made.model.movietrailer.TrailerResult
import com.yumtaufikhidayat.made.utils.loadVideoThumbnail
import com.yumtaufikhidayat.moviesx.databinding.ItemTrailerVideoBinding

class MovieTrailerVideoAdapter : ListAdapter<TrailerResult, MovieTrailerVideoAdapter.ViewHolder>(movieTrailerDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemTrailerVideoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemTrailerVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TrailerResult) {
            binding.apply {
                imgPoster.loadVideoThumbnail(data.key)
                tvTitle.text = data.name
                cardTrailerVideo.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube://${data.key}"))
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    companion object {
        val movieTrailerDiffCallback = object : DiffUtil.ItemCallback<TrailerResult>() {
            override fun areItemsTheSame(
                oldItem: TrailerResult,
                newItem: TrailerResult
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: TrailerResult,
                newItem: TrailerResult
            ): Boolean = oldItem == newItem
        }
    }
}