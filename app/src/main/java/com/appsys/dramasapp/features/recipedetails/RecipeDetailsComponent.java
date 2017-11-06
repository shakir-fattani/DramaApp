package com.appsys.dramasapp.features.recipedetails;

import com.appsys.dramasapp.data.source.RecipeRepositoryComponent;
import com.appsys.dramasapp.utils.FragmentScoped;
import dagger.Component;

@FragmentScoped
@Component(dependencies = RecipeRepositoryComponent.class, modules = RecipeDetailsPresenterModule.class)
public interface RecipeDetailsComponent {

  void inject(RecipeDetailsActivity recipeDetailsActivity);
}
