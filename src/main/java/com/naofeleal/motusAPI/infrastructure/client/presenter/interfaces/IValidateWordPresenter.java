package com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces;

import org.json.JSONObject;

public interface IValidateWordPresenter {
    public JSONObject present(boolean isWordValid);
}
