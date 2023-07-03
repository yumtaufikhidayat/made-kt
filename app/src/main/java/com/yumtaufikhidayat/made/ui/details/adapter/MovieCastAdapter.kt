package com.yumtaufikhidayat.made.ui.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.made.model.cast.Cast
import com.yumtaufikhidayat.made.utils.loadImage
import com.yumtaufikhidayat.moviesx.R
import com.yumtaufikhidayat.moviesx.databinding.ItemCastBinding

class MovieCastAdapter : ListAdapter<Cast, MovieCastAdapter.ViewHolder>(castDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCastBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCastBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Cast) {
            binding.apply {
                imgPoster.loadImage(data.profilePath)
                tvCastName.text = if (data.character.isNotEmpty()) {
                    root.context.getString(R.string.tvNameCharacter, data.name, data.character)
                } else {
                    root.context.getString(
                        R.string.tvNameCharacter,
                        data.name,
                        root.context.getString(R.string.tvNA)
                    )
                }
            }
        }
    }

    companion object {
        val castDiffCallback = object : DiffUtil.ItemCallback<Cast>() {
            override fun areItemsTheSame(
                oldItem: Cast,
                newItem: Cast
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Cast,
                newItem: Cast
            ): Boolean = oldItem == newItem
        }
    }
}