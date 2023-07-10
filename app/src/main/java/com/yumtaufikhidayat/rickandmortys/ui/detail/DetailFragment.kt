package com.yumtaufikhidayat.rickandmortys.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
            val status = character?.status ?: getString(R.string.tvNA)
            imgCharacter.loadImage(character?.image.orEmpty())
            tvCharacterName.text = character?.name ?: getString(R.string.tvNA)
            tvCharacterSpecies.text = character?.species ?: getString(R.string.tvNA)
            tvCharacterGender.text = character?.gender ?: getString(R.string.tvNA)
            tvCharacterStatus.apply {
                text = status
                textStatusColor(status)
            }
            tvCharacterCreatedAt.text = Common.covertDateToTime(character?.created.orEmpty())
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        const val EXTRA_DATA = "com.yumtaufikhidayat.rickandmortys.ui.detail.EXTRA_DATA"
    }
}