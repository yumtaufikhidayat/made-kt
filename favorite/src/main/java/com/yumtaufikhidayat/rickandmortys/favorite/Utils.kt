package com.yumtaufikhidayat.rickandmortys.favorite

import com.yumtaufikhidayat.rickandmortys.core.di.dfm.FavoriteModuleDependencies
import com.yumtaufikhidayat.rickandmortys.favorite.di.DaggerFavoriteComponent
import com.yumtaufikhidayat.rickandmortys.favorite.ui.FavoriteFragment
import dagger.hilt.android.EntryPointAccessors

internal fun FavoriteFragment.inject() {
    DaggerFavoriteComponent
        .builder()
        .context(requireContext())
        .appDependencies(
            EntryPointAccessors.fromApplication(
                requireContext(),
                FavoriteModuleDependencies::class.java
            )
        ).build()
        .inject(this)
}