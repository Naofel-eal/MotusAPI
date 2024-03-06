package com.naofeleal.motusAPI.infrastructure.client.presenter;

import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IValidateWordPresenter;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class ValidateWordPresenter implements IValidateWordPresenter {
    public ValidateWordPresenter() {}
    @Override
    public JSONObject present(boolean isWordValid) {
        JSONObject result = new JSONObject();
        result.put("result", isWordValid);
        return result;
    }
}
