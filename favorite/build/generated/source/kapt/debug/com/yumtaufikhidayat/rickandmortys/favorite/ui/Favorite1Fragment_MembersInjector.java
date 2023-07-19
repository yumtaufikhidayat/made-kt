package com.yumtaufikhidayat.rickandmortys.favorite.ui;

import com.yumtaufikhidayat.rickandmortys.favorite.ui.factory.ViewModelFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class Favorite1Fragment_MembersInjector implements MembersInjector<Favorite1Fragment> {
  private final Provider<ViewModelFactory> factoryProvider;

  public Favorite1Fragment_MembersInjector(Provider<ViewModelFactory> factoryProvider) {
    this.factoryProvider = factoryProvider;
  }

  public static MembersInjector<Favorite1Fragment> create(
      Provider<ViewModelFactory> factoryProvider) {
    return new Favorite1Fragment_MembersInjector(factoryProvider);
  }

  @Override
  public void injectMembers(Favorite1Fragment instance) {
    injectFactory(instance, factoryProvider.get());
  }

  @InjectedFieldSignature("com.yumtaufikhidayat.rickandmortys.favorite.ui.Favorite1Fragment.factory")
  public static void injectFactory(Favorite1Fragment instance, ViewModelFactory factory) {
    instance.factory = factory;
  }
}
