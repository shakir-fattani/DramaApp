package com.appsys.dramasapp.features.recipestep;

import com.appsys.dramasapp.data.source.RecipeRepositoryComponent;
import com.appsys.dramasapp.utils.FragmentScoped;
import dagger.Component;

@FragmentScoped
@Component(dependencies = RecipeRepositoryComponent.class, modules = RecipeStepPresenterModule.class)
interface RecipeStepComponent {

  void inject(RecipeStepActivity recipeStepActivity);
}
