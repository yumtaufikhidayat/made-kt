package com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.di.InjectionReactiveX
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.core.domain.usecase.TourismReactiveXUseCase
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.detail.DetailTourismReactiveXViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.favorite.FavoriteReactiveXViewModel
import com.yumtaufikhidayat.menjadiandroiddeveloperexpert.reactivex.project.home.HomeReactiveXViewModel

class ReactiveXViewModelFactory private constructor(
    private val tourismUseCase: TourismReactiveXUseCase
) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ReactiveXViewModelFactory? = null

        fun getInstance(context: Context): ReactiveXViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ReactiveXViewModelFactory(
                    InjectionReactiveX.provideTourismUseCase(context)
                )
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(HomeReactiveXViewModel::class.java) -> {
                HomeReactiveXViewModel(tourismUseCase) as T
            }

            modelClass.isAssignableFrom(FavoriteReactiveXViewModel::class.java) -> {
                FavoriteReactiveXViewModel(tourismUseCase) as T
            }

            modelClass.isAssignableFrom(DetailTourismReactiveXViewModel::class.java) -> {
                DetailTourismReactiveXViewModel(tourismUseCase) as T
            }

            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}