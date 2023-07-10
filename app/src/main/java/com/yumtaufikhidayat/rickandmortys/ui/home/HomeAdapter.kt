package com.yumtaufikhidayat.rickandmortys.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil.ItemCallback
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yumtaufikhidayat.rickandmortys.R
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character
import com.yumtaufikhidayat.rickandmortys.databinding.ItemCharactersBinding
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common.loadImage

class HomeAdapter(
    private val onItemClickListener: (Character) -> Unit
) : ListAdapter<Character, HomeAdapter.ViewHolder>(homeDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharactersBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemCharactersBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Character) {
            binding.apply {
                imgCharacter.loadImage(data.image)
                tvCharacterName.text = data.name
                tvSpecies.text = data.species

                val statusColor = when (data.status) {
                    "Alive" -> ContextCompat.getColor(itemView.context, android.R.color.holo_green_light)
                    "unknown" -> ContextCompat.getColor(itemView.context, R.color.colorSemiBlack)
                    else -> ContextCompat.getColor(itemView.context, android.R.color.holo_red_light)
                }

                tvStatus.apply {
                    text = data.status
                    setTextColor(statusColor)
                }

                itemView.setOnClickListener {
                    onItemClickListener(data)
                }
            }
        }
    }

    companion object {
        val homeDiffCallback = object : ItemCallback<Character>() {
            override fun areItemsTheSame(
                oldItem: Character,
                newItem: Character
            ): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: Character,
                newItem: Character
            ): Boolean = oldItem == newItem
        }
    }
}