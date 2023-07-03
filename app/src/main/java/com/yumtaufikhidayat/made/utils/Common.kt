package com.yumtaufikhidayat.made.utils

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yumtaufikhidayat.made.ui.details.fragment.DetailMovieFragment
import com.yumtaufikhidayat.moviesx.R
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt

fun ImageView.loadImage(url: String?) {
    Glide.with(this.context)
        .load(Constant.IMAGE_URL + url)
        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
        .into(this)
}

fun ImageView.loadVideoThumbnail(url: String?) {
    Glide.with(this.context)
        .load(Constant.THUMBNAIL_IMAGE_URL + url + Constant.THUMBNAIL_IMAGE_JPG)
        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
        .into(this)
}

fun String.convertDate(inputFormat: String, outputFormat: String): String {
    val formatter = SimpleDateFormat(inputFormat, Locale.US)
    var formatParser = Date()
    if (this.isNotEmpty()) {
        formatParser = formatter.parse(this) ?: Date()
    }
    val newOutputFormat = SimpleDateFormat(outputFormat, Locale.US)
    return newOutputFormat.format(formatParser)
}

fun Fragment.navigateToDetail(id: Int, title: String) {
    val bundle = Bundle().apply {
        putInt(DetailMovieFragment.EXTRA_ID, id)
        putString(DetailMovieFragment.EXTRA_TITLE, title)
    }
    this.findNavController().navigate(R.id.detailMovieFragment, bundle)
}

fun toRating(data: Double): String {
    val tenDouble = 10.0
    return ((data * tenDouble).roundToInt() / tenDouble).toString()
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}



fun showError(tag: String, message: String) {
    Log.e(tag, "Error: $message")
}