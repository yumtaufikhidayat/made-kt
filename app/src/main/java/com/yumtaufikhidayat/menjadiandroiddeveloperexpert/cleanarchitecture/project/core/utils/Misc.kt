package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.utils

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.core.domain.model.Tourism
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.cleanarchitecture.project.detail.DetailTourismActivity

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(context: Context, url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun Fragment.navigateToDetail(data: Tourism) {
    val intent = Intent(requireContext(), DetailTourismActivity::class.java)
    intent.putExtra(DetailTourismActivity.EXTRA_DATA, data)
    this.startActivity(intent)
}