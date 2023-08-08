package com.yumtaufikhidayat.rickandmortys.favorite.ui;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u001a\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\u0018\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006,"}, d2 = {"Lcom/yumtaufikhidayat/rickandmortys/favorite/ui/FavoriteFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/yumtaufikhidayat/rickandmortys/favorite/databinding/FragmentFavoriteBinding;", "binding", "getBinding", "()Lcom/yumtaufikhidayat/rickandmortys/favorite/databinding/FragmentFavoriteBinding;", "factory", "Lcom/yumtaufikhidayat/rickandmortys/favorite/ui/factory/ViewModelFactory;", "getFactory", "()Lcom/yumtaufikhidayat/rickandmortys/favorite/ui/factory/ViewModelFactory;", "setFactory", "(Lcom/yumtaufikhidayat/rickandmortys/favorite/ui/factory/ViewModelFactory;)V", "homeAdapter", "Lcom/yumtaufikhidayat/rickandmortys/ui/home/HomeAdapter;", "viewModel", "Lcom/yumtaufikhidayat/rickandmortys/favorite/ui/FavoriteViewModel;", "getViewModel", "()Lcom/yumtaufikhidayat/rickandmortys/favorite/ui/FavoriteViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onAttach", "", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setFavoriteAdapter", "setFavoriteData", "showError", "isVisible", "", "message", "", "favorite_debug"})
public final class FavoriteFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.yumtaufikhidayat.rickandmortys.favorite.databinding.FragmentFavoriteBinding _binding;
    @javax.inject.Inject
    public com.yumtaufikhidayat.rickandmortys.favorite.ui.factory.ViewModelFactory factory;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private com.yumtaufikhidayat.rickandmortys.ui.home.HomeAdapter homeAdapter;
    
    public FavoriteFragment() {
        super();
    }
    
    private final com.yumtaufikhidayat.rickandmortys.favorite.databinding.FragmentFavoriteBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.yumtaufikhidayat.rickandmortys.favorite.ui.factory.ViewModelFactory getFactory() {
        return null;
    }
    
    public final void setFactory(@org.jetbrains.annotations.NotNull
    com.yumtaufikhidayat.rickandmortys.favorite.ui.factory.ViewModelFactory p0) {
    }
    
    private final com.yumtaufikhidayat.rickandmortys.favorite.ui.FavoriteViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onAttach(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setFavoriteAdapter() {
    }
    
    private final void setFavoriteData() {
    }
    
    private final void showError(boolean isVisible, java.lang.String message) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}