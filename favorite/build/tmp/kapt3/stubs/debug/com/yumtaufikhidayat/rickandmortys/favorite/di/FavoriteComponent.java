package com.yumtaufikhidayat.rickandmortys.favorite.di;

@javax.inject.Singleton
@dagger.Component(dependencies = {com.yumtaufikhidayat.rickandmortys.core.di.dfm.FavoriteDependencies.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/yumtaufikhidayat/rickandmortys/favorite/di/FavoriteComponent;", "", "inject", "", "fragment", "Lcom/yumtaufikhidayat/rickandmortys/favorite/ui/FavoriteFragment;", "Builder", "favorite_debug"})
public abstract interface FavoriteComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull
    com.yumtaufikhidayat.rickandmortys.favorite.ui.FavoriteFragment fragment);
    
    @dagger.Component.Builder
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00002\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/yumtaufikhidayat/rickandmortys/favorite/di/FavoriteComponent$Builder;", "", "build", "Lcom/yumtaufikhidayat/rickandmortys/favorite/di/FavoriteComponent;", "context", "Landroid/content/Context;", "create", "favoriteDependencies", "Lcom/yumtaufikhidayat/rickandmortys/core/di/dfm/FavoriteDependencies;", "favorite_debug"})
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.yumtaufikhidayat.rickandmortys.favorite.di.FavoriteComponent.Builder context(@dagger.BindsInstance
        @org.jetbrains.annotations.NotNull
        android.content.Context context);
        
        @org.jetbrains.annotations.NotNull
        public abstract com.yumtaufikhidayat.rickandmortys.favorite.di.FavoriteComponent.Builder create(@org.jetbrains.annotations.NotNull
        com.yumtaufikhidayat.rickandmortys.core.di.dfm.FavoriteDependencies favoriteDependencies);
        
        @org.jetbrains.annotations.NotNull
        public abstract com.yumtaufikhidayat.rickandmortys.favorite.di.FavoriteComponent build();
    }
}