package com.yumtaufikhidayat.rickandmortys.favorite.di

import android.content.Context
import com.yumtaufikhidayat.rickandmortys.core.di.dfm.FavoriteModuleDependencies
import com.yumtaufikhidayat.rickandmortys.favorite.ui.FavoriteFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [FavoriteModuleDependencies::class]
)
interface FavoriteComponent {

    fun inject(fragment: FavoriteFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }
}