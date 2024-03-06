package com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces;

import com.naofeleal.motusAPI.core.domain.model.Word;
import org.json.JSONObject;

import java.util.List;

public interface IFetchWordPresenter {
    public JSONObject present(List<Word> words);
}
