package com.naofeleal.motusAPI.infrastructure.client.presenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IGetAllLanguagesPresenter;

@Component
public class GetAllLanguagesPresenter implements IGetAllLanguagesPresenter{
    public GetAllLanguagesPresenter() { }

    @Override
    public Map<String, Object> present(List<Language> languages) {
        Map<String, Object> result = new HashMap<>();
        List<String> languagesIsoCode = languages.stream().map(language -> language.isoCode).collect(Collectors.toList());
        result.put("languages", languagesIsoCode);
        return result; 
    }
    
}
