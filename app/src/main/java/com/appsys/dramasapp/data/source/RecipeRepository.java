package com.appsys.dramasapp.data.source;

import com.appsys.dramasapp.data.model.Ingredient;
import com.appsys.dramasapp.data.model.Recipe;
import com.appsys.dramasapp.data.model.Step;
import com.appsys.dramasapp.data.source.local.Local;
import com.appsys.dramasapp.data.source.local.prefs.PreferencesHelper;
import com.appsys.dramasapp.data.source.remote.Remote;
import com.appsys.dramasapp.utils.RxUtils;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class RecipeRepository implements RecipeDataSource {

  private final RecipeDataSource recipeRemoteDataSource;
  private final RecipeDataSource recipeLocalDataSource;
  private final PreferencesHelper preferencesHelper;

  @Inject
  public RecipeRepository(
      @Remote RecipeDataSource recipeRemoteDataSource,
      @Local RecipeDataSource recipeLocalDataSource,
      PreferencesHelper preferencesHelper) {
    this.recipeRemoteDataSource = recipeRemoteDataSource;
    this.recipeLocalDataSource = recipeLocalDataSource;
    this.preferencesHelper = preferencesHelper;
  }

  @Override
  public Observable<List<Recipe>> getRecipes() {

    if (!preferencesHelper.isRecipeListSynced()) {
      return recipeRemoteDataSource
          .getRecipes()
          .compose(RxUtils.applySchedulers())
          .doOnNext(recipeList -> {
            recipeLocalDataSource.saveRecipes(recipeList);
            preferencesHelper.saveRecipeNamesList(recipeList);
          });
    } else {
      return recipeLocalDataSource
          .getRecipes()
          .compose(RxUtils.applySchedulers());
    }
  }

  @Override
  public Observable<List<Ingredient>> getRecipeIngredients(int recipeId) {
    return recipeLocalDataSource
        .getRecipeIngredients(recipeId)
        .compose(RxUtils.applySchedulers());
  }

  @Override
  public Observable<List<Ingredient>> getRecipeIngredients(String recipeName) {
    return recipeLocalDataSource
        .getRecipeIngredients(recipeName)
        .compose(RxUtils.applySchedulers());
  }

  @Override
  public Observable<List<Step>> getRecipeSteps(int recipeId) {
    return recipeLocalDataSource
        .getRecipeSteps(recipeId)
        .compose(RxUtils.applySchedulers());
  }

  @Override
  public void saveRecipes(List<Recipe> recipes) {
    recipeLocalDataSource.saveRecipes(recipes);
  }

  public void markRepoAsSynced(boolean synced) {
    preferencesHelper.setRecipeListSynced(synced);
  }

  public PreferencesHelper getPreferencesHelper() {
    return preferencesHelper;
  }
}
