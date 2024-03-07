package com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces;

import com.naofeleal.motusAPI.core.domain.model.Word;

import java.util.List;
import java.util.Map;

public interface IFetchWordPresenter {
    public Map<String, Object> present(List<Word> words);
}
