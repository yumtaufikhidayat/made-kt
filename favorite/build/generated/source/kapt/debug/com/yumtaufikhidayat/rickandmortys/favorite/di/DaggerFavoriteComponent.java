package com.yumtaufikhidayat.rickandmortys.favorite.di;

import android.content.Context;
import com.yumtaufikhidayat.rickandmortys.core.di.dfm.FavoriteDependencies;
import com.yumtaufikhidayat.rickandmortys.favorite.ui.FavoriteFragment;
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

    private FavoriteDependencies favoriteDependencies;

    @Override
    public Builder context(Context context) {
      this.context = Preconditions.checkNotNull(context);
      return this;
    }

    @Override
    public Builder create(FavoriteDependencies favoriteDependencies) {
      this.favoriteDependencies = Preconditions.checkNotNull(favoriteDependencies);
      return this;
    }

    @Override
    public FavoriteComponent build() {
      Preconditions.checkBuilderRequirement(context, Context.class);
      Preconditions.checkBuilderRequirement(favoriteDependencies, FavoriteDependencies.class);
      return new FavoriteComponentImpl(favoriteDependencies, context);
    }
  }

  private static final class FavoriteComponentImpl implements FavoriteComponent {
    private final FavoriteComponentImpl favoriteComponentImpl = this;

    private FavoriteComponentImpl(FavoriteDependencies favoriteDependenciesParam,
        Context contextParam) {


    }

    @Override
    public void inject(FavoriteFragment fragment) {
    }
  }
}
