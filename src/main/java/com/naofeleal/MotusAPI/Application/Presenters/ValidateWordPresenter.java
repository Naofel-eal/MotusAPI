package com.naofeleal.MotusAPI.Application.Presenters;

import com.naofeleal.MotusAPI.Application.IPresenters.IValidateWordPresenter;

public class ValidateWordPresenter implements IValidateWordPresenter {
    public boolean result = false;

    public ValidateWordPresenter() {}

    @Override
    public void present(boolean repositoryResult) {
        this.result = repositoryResult;
    }
}
