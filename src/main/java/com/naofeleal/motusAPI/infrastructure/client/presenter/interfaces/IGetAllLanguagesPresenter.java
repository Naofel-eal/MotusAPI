package com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces;

import java.util.List;
import java.util.Map;

import com.naofeleal.motusAPI.core.domain.model.Language;

public interface IGetAllLanguagesPresenter {
    public Map<String, Object> present(List<Language> languages);
}
