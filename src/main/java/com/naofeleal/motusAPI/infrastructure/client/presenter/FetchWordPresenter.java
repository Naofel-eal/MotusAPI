package com.naofeleal.motusAPI.infrastructure.client.presenter;

import com.naofeleal.motusAPI.core.domain.model.Word;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IFetchWordPresenter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FetchWordPresenter implements IFetchWordPresenter {

    public FetchWordPresenter() {}

    @Override
    public JSONObject present(List<Word> words) {
        JSONObject result = new JSONObject();
        JSONArray wordJSONArray = new JSONArray();

        for (Word word : words) wordJSONArray.put(word.value);
        result.put("words", wordJSONArray);

        return result;
    }
}
