package com.yumtaufikhidayat.rickandmortys.ui.utils

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.yumtaufikhidayat.rickandmortys.R
import com.yumtaufikhidayat.rickandmortys.core.domain.model.Character
import com.yumtaufikhidayat.rickandmortys.ui.detail.DetailFragment
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

object Common {
    fun ImageView.loadImage(url: String?) {
        Glide.with(this.context)
            .load(url)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
            .into(this)
    }

    fun TextView.textStatusColor(status: String) {
        val statusColor = when (status) {
            "Alive" -> ContextCompat.getColor(this.context, android.R.color.holo_green_light)
            "unknown" -> ContextCompat.getColor(this.context, R.color.colorSemiBlack)
            else -> ContextCompat.getColor(this.context, android.R.color.holo_red_light)
        }
        this.setTextColor(statusColor)
    }

    fun Fragment.navigateToDetail(data: Character) {
        val bundle = Bundle()
        bundle.putParcelable(DetailFragment.EXTRA_DATA, data)
        this.findNavController().navigate(R.id.detailFragment, bundle)
    }

    fun covertDateToTime(dataDate: String?): String? {
        var convTime: String? = null
        val suffix = "ago"
        try {
            val dateFormat = SimpleDateFormat(Constants.DEFAULT_TIME, Locale.getDefault())
            val pasTime = dataDate?.let { dateFormat.parse(it) }
            val nowTime = Date()
            val dateDiff = nowTime.time - (pasTime?.time ?: 0)
            val second: Long = TimeUnit.MILLISECONDS.toSeconds(dateDiff)
            val minute: Long = TimeUnit.MILLISECONDS.toMinutes(dateDiff)
            val hour: Long = TimeUnit.MILLISECONDS.toHours(dateDiff)
            val day: Long = TimeUnit.MILLISECONDS.toDays(dateDiff)

            when {
                second < 60 -> convTime = "$second second(s) $suffix"
                minute < 60 -> convTime = "$minute month(s) $suffix"
                hour < 24 -> convTime = "$hour hour(s) $suffix"
                day >= 7 -> {
                    convTime = if (day > 360) {
                        "${day/360} year(s) $suffix"
                    } else if (day > 30) {
                        "${day/36} month(s) $suffix"
                    } else {
                        "${day/7} week(s) $suffix"
                    }
                }
                day < 7 -> convTime = "$day day(s) $suffix"
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return convTime
    }
}