package com.yumtaufikhidayat.rickandmortys.favorite.ui.factory;

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
public final class ViewModelFactory_Factory implements Factory<ViewModelFactory> {
  private final Provider<CharacterUseCase> characterUseCaseProvider;

  public ViewModelFactory_Factory(Provider<CharacterUseCase> characterUseCaseProvider) {
    this.characterUseCaseProvider = characterUseCaseProvider;
  }

  @Override
  public ViewModelFactory get() {
    return newInstance(characterUseCaseProvider.get());
  }

  public static ViewModelFactory_Factory create(
      Provider<CharacterUseCase> characterUseCaseProvider) {
    return new ViewModelFactory_Factory(characterUseCaseProvider);
  }

  public static ViewModelFactory newInstance(CharacterUseCase characterUseCase) {
    return new ViewModelFactory(characterUseCase);
  }
}
