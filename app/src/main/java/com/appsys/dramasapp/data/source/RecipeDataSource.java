package com.appsys.dramasapp.data.source;

import com.appsys.dramasapp.data.model.Ingredient;
import com.appsys.dramasapp.data.model.Recipe;
import com.appsys.dramasapp.data.model.Step;
import io.reactivex.Observable;
import java.util.List;

public interface RecipeDataSource {

  Observable<List<Recipe>> getRecipes();

  Observable<List<Ingredient>> getRecipeIngredients(int recipeId);

  Observable<List<Ingredient>> getRecipeIngredients(String recipeName);

  Observable<List<Step>> getRecipeSteps(int recipeId);

  void saveRecipes(List<Recipe> recipes);
}
