package com.yumtaufikhidayat.rickandmortys.favorite.di;

import android.content.Context;
import com.yumtaufikhidayat.rickandmortys.core.di.dfm.FavoriteModuleDependencies;
import com.yumtaufikhidayat.rickandmortys.favorite.ui.FavoriteFragment;
import com.yumtaufikhidayat.rickandmortys.favorite.ui.FavoriteFragment_MembersInjector;
import com.yumtaufikhidayat.rickandmortys.favorite.ui.factory.ViewModelFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;

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
public final class DaggerFavoriteComponent {
  private DaggerFavoriteComponent() {
  }

  public static FavoriteComponent.Builder builder() {
    return new Builder();
  }

  private static final class Builder implements FavoriteComponent.Builder {
    private Context context;

    private FavoriteModuleDependencies favoriteModuleDependencies;

    @Override
    public Builder context(Context context) {
      this.context = Preconditions.checkNotNull(context);
      return this;
    }

    @Override
    public Builder appDependencies(FavoriteModuleDependencies favoriteDependencies) {
      this.favoriteModuleDependencies = Preconditions.checkNotNull(favoriteDependencies);
      return this;
    }

    @Override
    public FavoriteComponent build() {
      Preconditions.checkBuilderRequirement(context, Context.class);
      Preconditions.checkBuilderRequirement(favoriteModuleDependencies, FavoriteModuleDependencies.class);
      return new FavoriteComponentImpl(favoriteModuleDependencies, context);
    }
  }

  private static final class FavoriteComponentImpl implements FavoriteComponent {
    private final FavoriteModuleDependencies favoriteModuleDependencies;

    private final FavoriteComponentImpl favoriteComponentImpl = this;

    private FavoriteComponentImpl(FavoriteModuleDependencies favoriteModuleDependenciesParam,
        Context contextParam) {
      this.favoriteModuleDependencies = favoriteModuleDependenciesParam;

    }

    private ViewModelFactory viewModelFactory() {
      return new ViewModelFactory(Preconditions.checkNotNullFromComponent(favoriteModuleDependencies.providesCharacterUseCase()));
    }

    @Override
    public void inject(FavoriteFragment fragment) {
      injectFavoriteFragment(fragment);
    }

    private FavoriteFragment injectFavoriteFragment(FavoriteFragment instance) {
      FavoriteFragment_MembersInjector.injectFactory(instance, viewModelFactory());
      return instance;
    }
  }
}
