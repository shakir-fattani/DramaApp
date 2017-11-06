package com.appsys.dramasapp.data.source.remote;

import com.appsys.dramasapp.data.model.Ingredient;
import com.appsys.dramasapp.data.model.Recipe;
import com.appsys.dramasapp.data.model.Step;
import com.appsys.dramasapp.data.source.RecipeDataSource;
import com.appsys.dramasapp.utils.RxUtils;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import timber.log.Timber;

@Singleton
public class RecipeRemoteDataSource implements RecipeDataSource {

  private final RecipeService service;

  @Inject
  public RecipeRemoteDataSource(RecipeService service) {
    this.service = service;
  }

  @Override
  public Observable<List<Recipe>> getRecipes() {
    return service
        .loadRecipesFromServer()
        .compose(RxUtils.applySchedulers())
        .doOnSubscribe(disposable -> Timber.d("Sync started..."))
        .doOnError(throwable ->  Timber.d("Sync failed!"))
        .doOnComplete(() -> Timber.d("Sync completed."));
  }

  @Override
  public Observable<List<Ingredient>> getRecipeIngredients(int recipeId) {
    throw new UnsupportedOperationException("getRecipeIngredients in RemoteDataSource is not implemented!");
  }

  @Override
  public Observable<List<Ingredient>> getRecipeIngredients(String recipeName) {
    throw new UnsupportedOperationException("getRecipeIngredients in RemoteDataSource is not implemented!");
  }

  @Override
  public Observable<List<Step>> getRecipeSteps(int recipeId) {
    throw new UnsupportedOperationException("getRecipeSteps in RemoteDataSource is not implemented!");
  }

  @Override
  public void saveRecipes(List<Recipe> recipes) {
    throw new UnsupportedOperationException("saveRecipes in RemoteDataSource is not implemented!");
  }
}
