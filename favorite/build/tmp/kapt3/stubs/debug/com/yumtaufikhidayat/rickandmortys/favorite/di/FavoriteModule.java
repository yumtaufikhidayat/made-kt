package com.yumtaufikhidayat.rickandmortys.favorite.di;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/yumtaufikhidayat/rickandmortys/favorite/di/FavoriteModule;", "", "provideFavoriteCharacterRepository", "Lcom/yumtaufikhidayat/rickandmortys/core/data/CharacterRepository;", "favorite_debug"})
@dagger.hilt.EntryPoint
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract interface FavoriteModule {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.yumtaufikhidayat.rickandmortys.core.data.CharacterRepository provideFavoriteCharacterRepository();
}