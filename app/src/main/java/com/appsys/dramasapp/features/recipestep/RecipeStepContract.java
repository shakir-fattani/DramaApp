package com.appsys.dramasapp.features.recipestep;

import com.appsys.dramasapp.BasePresenter;
import com.appsys.dramasapp.BaseView;
import com.appsys.dramasapp.data.model.Step;
import java.util.List;

class RecipeStepContract {

  interface View extends BaseView<Presenter> {

    void showStepsInViewpager(List<Step> steps);

    void showErrorMessage();

    void moveToCurrentStepPage();
  }

  interface Presenter extends BasePresenter {

    void loadStepsToAdapter();
  }
}
