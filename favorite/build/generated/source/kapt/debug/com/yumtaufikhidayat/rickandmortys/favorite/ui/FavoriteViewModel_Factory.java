package com.yumtaufikhidayat.rickandmortys.favorite.ui;

import com.yumtaufikhidayat.rickandmortys.core.domain.usecase.CharacterUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class FavoriteViewModel_Factory implements Factory<FavoriteViewModel> {
  private final Provider<CharacterUseCase> characterUseCaseProvider;

  public FavoriteViewModel_Factory(Provider<CharacterUseCase> characterUseCaseProvider) {
    this.characterUseCaseProvider = characterUseCaseProvider;
  }

  @Override
  public FavoriteViewModel get() {
    return newInstance(characterUseCaseProvider.get());
  }

  public static FavoriteViewModel_Factory create(
      Provider<CharacterUseCase> characterUseCaseProvider) {
    return new FavoriteViewModel_Factory(characterUseCaseProvider);
  }

  public static FavoriteViewModel newInstance(CharacterUseCase characterUseCase) {
    return new FavoriteViewModel(characterUseCase);
  }
}
