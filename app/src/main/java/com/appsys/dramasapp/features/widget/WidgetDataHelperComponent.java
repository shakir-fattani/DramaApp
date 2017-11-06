package com.appsys.dramasapp.features.widget;

import com.appsys.dramasapp.BakingAppModule;
import com.appsys.dramasapp.data.source.RecipeRepositoryComponent;
import com.appsys.dramasapp.utils.ProviderScoped;
import dagger.Component;

@ProviderScoped
@Component(dependencies = RecipeRepositoryComponent.class, modules = BakingAppModule.class)
interface WidgetDataHelperComponent {

  void inject(WidgetProvider provider);
  void inject(WidgetConfigurationActivity activity);
}
