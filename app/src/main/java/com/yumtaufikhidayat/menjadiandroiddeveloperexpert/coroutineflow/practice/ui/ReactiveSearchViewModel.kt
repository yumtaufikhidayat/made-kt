package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.coroutineflow.practice.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.coroutineflow.practice.network.ApiConfig
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.mapLatest

@FlowPreview
@ExperimentalCoroutinesApi
class ReactiveSearchViewModel : ViewModel(){

    private val accessToken = "YOUR_TOKEN_HERE"
    val queryChannel = MutableStateFlow("")

    val searchResult = queryChannel
        .debounce(300L)
        .distinctUntilChanged()
        .filter {
            it.trim().isNotEmpty()
        }
        .mapLatest {
            ApiConfig.provideApiService().getCountry(it, accessToken).features
        }
        .asLiveData()
}