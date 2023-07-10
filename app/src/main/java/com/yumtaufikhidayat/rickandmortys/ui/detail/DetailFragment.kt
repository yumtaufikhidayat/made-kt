package com.yumtaufikhidayat.rickandmortys.ui.detail

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yumtaufikhidayat.rickandmortys.R
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character
import com.yumtaufikhidayat.rickandmortys.databinding.FragmentDetailBinding
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common.loadImage
import com.yumtaufikhidayat.rickandmortys.ui.utils.Common.textStatusColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailViewModel by viewModels()
    private var character: Character? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleToolbar()
        getBundleData()
        setDetailCharacterInformation()
    }

    private fun handleToolbar() {
        binding.toolbarDetail.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getBundleData() {
        character = arguments?.getParcelable(EXTRA_DATA)
    }

    private fun setDetailCharacterInformation() {
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
                    viewModel.setFavoriteCharacter(data, statusFavorite)
                    setFavoriteCharacter(statusFavorite)
                }
            }
        }
    }

    private fun setFavoriteCharacter(isFavorite: Boolean?) {
        binding.toolbarDetail.imgFavorite.apply {
            if (isFavorite == true) {
                setImageDrawable(setFavoriteIconInfo(R.drawable.ic_favorite))
                showToast("Saved to favorite")
            } else {
                setImageDrawable(setFavoriteIconInfo(R.drawable.ic_not_favorite))
                showToast("Removed from favorite")
            }
        }
    }

    private fun setFavoriteIconInfo(icon: Int): Drawable? = ContextCompat.getDrawable(requireContext(), icon)

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val EXTRA_DATA = "com.yumtaufikhidayat.rickandmortys.ui.detail.EXTRA_DATA"
    }
}