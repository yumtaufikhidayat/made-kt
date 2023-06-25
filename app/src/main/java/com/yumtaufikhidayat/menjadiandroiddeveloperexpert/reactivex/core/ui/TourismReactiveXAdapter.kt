package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.databinding.ItemListTourismBinding
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.domain.model.TourismReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.core.utils.loadImage

class TourismReactiveXAdapter(
    private val onItemClickListener: (TourismReactiveX) -> Unit
) : ListAdapter<TourismReactiveX, TourismReactiveXAdapter.TourismViewHolder>(tourismDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourismViewHolder {
        return TourismViewHolder(
            ItemListTourismBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TourismViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TourismViewHolder(private val binding: ItemListTourismBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TourismReactiveX) {
            binding.apply {
                ivItemImage.loadImage(itemView.context, data.image)
                tvItemTitle.text = data.name
                tvItemSubtitle.text = data.address
                itemView.setOnClickListener {
                    onItemClickListener.invoke(data)
                }
            }
        }
    }

    companion object {
        val tourismDiffCallback = object : DiffUtil.ItemCallback<TourismReactiveX>() {
            override fun areItemsTheSame(oldItem: TourismReactiveX, newItem: TourismReactiveX): Boolean {
                return oldItem.tourismId == newItem.tourismId
            }

            override fun areContentsTheSame(oldItem: TourismReactiveX, newItem: TourismReactiveX): Boolean {
                return oldItem == newItem
            }
        }
    }
}
