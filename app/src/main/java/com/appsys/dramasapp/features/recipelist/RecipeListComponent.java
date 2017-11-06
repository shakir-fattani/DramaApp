package com.appsys.dramasapp.features.recipelist;

import com.appsys.dramasapp.data.source.RecipeRepositoryComponent;
import com.appsys.dramasapp.utils.FragmentScoped;
import dagger.Component;

@FragmentScoped
@Component(dependencies = RecipeRepositoryComponent.class, modules = RecipeListPresenterModule.class)
interface RecipeListComponent {

  void inject(RecipeListActivity recipeListActivity);
}
