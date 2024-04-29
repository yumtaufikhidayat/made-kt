package com.yumtaufikhidayat.rickandmortys.ui.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yumtaufikhidayat.rickandmortys.R
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character
import com.yumtaufikhidayat.rickandmortys.databinding.FragmentDetailBinding
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common.loadImage
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common.textStatusColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding<FragmentDetailBinding>()

    private val viewModel: DetailViewModel by viewModels()
    private var character: Character? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleToolbar()
        getBundleData()
    }

    private fun handleToolbar() {
        binding.toolbarDetail.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getBundleData() {
        character = arguments?.getParcelable(EXTRA_DATA)
        setDetailCharacterInformation(character)
    }

    private fun setDetailCharacterInformation(character: Character?) {
        binding.apply {
            character?.let { data ->
                imgCharacter.loadImage(data.image)
                tvCharacterName.text = data.name
                tvCharacterSpecies.text = data.species
                tvCharacterGender.text = data.gender

                val status = data.status
                tvCharacterStatus.apply {
                    text = status
                    textStatusColor(status)
                }

                tvCharacterCreatedAt.text = Common.covertDateToTime(data.created)

                var statusFavorite = data.isFavorite
                setFavoriteCharacter(statusFavorite)
                toolbarDetail.imgFavorite.setOnClickListener {
                    statusFavorite = !statusFavorite
                    if (statusFavorite)
                        showToast(getString(R.string.tvSavedToFavorite))
                    else
                        showToast(getString(R.string.tvRemovedToFavorite))
                    viewModel.setFavoriteCharacter(data, statusFavorite)
                    setFavoriteCharacter(statusFavorite)
                }
            }
        }
    }

    private fun setFavoriteCharacter(isFavorite: Boolean) {
        binding.toolbarDetail.imgFavorite.apply {
            setImageDrawable(setFavoriteIcon(
                if (isFavorite)
                    R.drawable.ic_favorite
                else
                    R.drawable.ic_not_favorite
                )
            )
        }
    }

    private fun setFavoriteIcon(icon: Int): Drawable? = ContextCompat.getDrawable(requireContext(), icon)

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val EXTRA_DATA = "com.yumtaufikhidayat.rickandmortys.ui.detail.EXTRA_DATA"
    }
}