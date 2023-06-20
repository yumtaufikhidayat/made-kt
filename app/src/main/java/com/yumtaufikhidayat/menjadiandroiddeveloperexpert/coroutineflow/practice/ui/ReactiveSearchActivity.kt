package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.coroutineflow.practice.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.databinding.ActivityReactiveSearchBinding
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch

class ReactiveSearchActivity : AppCompatActivity() {

    private val binding by lazy { ActivityReactiveSearchBinding.inflate(layoutInflater) }

    @OptIn(FlowPreview::class)
    private val viewModel by viewModels<ReactiveSearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setSearchInput()
    }

    @OptIn(FlowPreview::class)
    private fun setSearchInput() {
        binding.apply {
            edPlace.addTextChangedListener(onTextChanged = { sequence, _, _, _ ->
                lifecycleScope.launch {
                    viewModel.queryChannel.value = sequence.toString()
                }
            })

            viewModel.searchResult.observe(this@ReactiveSearchActivity) { listOfPlaces ->
                val placeName = listOfPlaces.map { it.placeName }
                val adapter = ArrayAdapter(this@ReactiveSearchActivity, android.R.layout.select_dialog_item, placeName)
                adapter.notifyDataSetChanged()
                edPlace.setAdapter(adapter)
            }
        }
    }
}