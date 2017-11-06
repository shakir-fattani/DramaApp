package com.appsys.dramasapp.features.widget;

import com.appsys.dramasapp.data.model.Ingredient;
import com.appsys.dramasapp.data.source.RecipeRepository;
import io.reactivex.Observable;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

public class WidgetDataHelper {

  private final RecipeRepository recipeRepository;

  @Inject
  public WidgetDataHelper(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;
  }

  Set<String> getRecipeNamesFromPrefs() {
    return recipeRepository.getPreferencesHelper().getRecipeNamesList();
  }

  void deleteRecipeFromPrefs(int widgetId) {
    recipeRepository.getPreferencesHelper().deleteRecipeName(widgetId);
  }

  void saveRecipeNameToPrefs(int appWidgetId, String name) {
    recipeRepository.getPreferencesHelper().saveChosenRecipeName(appWidgetId, name);
  }

  String getRecipeNameFromPrefs(int appWidgetId) {
    return recipeRepository.getPreferencesHelper().getChosenRecipeName(appWidgetId);
  }

  Observable<List<Ingredient>> getIngredientsList(String recipeName) {
    return recipeRepository.getRecipeIngredients(recipeName);
  }
}
