package com.appsys.dramasapp.data.source;

import com.appsys.dramasapp.BakingAppModule;
import com.appsys.dramasapp.data.source.local.db.DbModule;
import com.appsys.dramasapp.data.source.local.prefs.PreferencesModule;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {RecipeRepositoryModule.class, DbModule.class, PreferencesModule.class,
    BakingAppModule.class})
public interface RecipeRepositoryComponent {

  RecipeRepository getRecipeRepository();
}
