package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.utils

import android.content.Context
import android.content.Intent
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.model.TourismReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.detail.DetailTourismReactiveXActivity

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun ImageView.loadImage(context: Context, url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}

fun Fragment.navigateToDetail(data: TourismReactiveX) {
    val intent = Intent(requireContext(), DetailTourismReactiveXActivity::class.java)
    intent.putExtra(DetailTourismReactiveXActivity.EXTRA_DATA, data)
    this.startActivity(intent)
}