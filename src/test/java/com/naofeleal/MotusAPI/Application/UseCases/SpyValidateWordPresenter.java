package com.naofeleal.MotusAPI.Application.UseCases;

import com.naofeleal.MotusAPI.Application.IPresenters.IValidateWordPresenter;

public class SpyValidateWordPresenter implements IValidateWordPresenter {
    public boolean isPresentCalled = false;
    public boolean presentResult = false;

    @Override
    public void present(boolean result) {
        this.isPresentCalled = true;
        this.presentResult = result;
    }
}
