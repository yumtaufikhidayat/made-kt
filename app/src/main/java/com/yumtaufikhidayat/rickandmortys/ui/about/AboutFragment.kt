package com.yumtaufikhidayat.rickandmortys.ui.about

import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.yumtaufikhidayat.rickandmortys.R
import com.yumtaufikhidayat.rickandmortys.databinding.FragmentAboutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : Fragment(R.layout.fragment_about) {

    private val binding by viewBinding<FragmentAboutBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAboutInfo()
    }

    private fun setAboutInfo() {
        try {
            val pInfo = activity?.packageManager?.getPackageInfo(activity?.packageName.toString(), 0)
            val appVersion = pInfo?.versionName
            binding.tvAppVersion.text = appVersion
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }
}