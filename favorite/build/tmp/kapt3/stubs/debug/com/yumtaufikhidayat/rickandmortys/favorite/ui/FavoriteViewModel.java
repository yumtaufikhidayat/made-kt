package com.yumtaufikhidayat.rickandmortys.favorite.ui;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/yumtaufikhidayat/rickandmortys/favorite/ui/FavoriteViewModel;", "Landroidx/lifecycle/ViewModel;", "characterUseCase", "Lcom/yumtaufikhidayat/rickandmortys/core/domain/usecase/CharacterUseCase;", "(Lcom/yumtaufikhidayat/rickandmortys/core/domain/usecase/CharacterUseCase;)V", "favoriteCharacter", "Landroidx/lifecycle/LiveData;", "", "Lcom/yumtaufikhidayat/rickandmortys/core/domain/model/Character;", "getFavoriteCharacter", "()Landroidx/lifecycle/LiveData;", "favorite_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class FavoriteViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.yumtaufikhidayat.rickandmortys.core.domain.model.Character>> favoriteCharacter = null;
    
    @javax.inject.Inject()
    public FavoriteViewModel(@org.jetbrains.annotations.NotNull()
    com.yumtaufikhidayat.rickandmortys.core.domain.usecase.CharacterUseCase characterUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.yumtaufikhidayat.rickandmortys.core.domain.model.Character>> getFavoriteCharacter() {
        return null;
    }
}