package com.naofeleal.motusAPI.core.application.repository;

import java.util.List;

import com.naofeleal.motusAPI.core.domain.model.Language;

public interface ILanguageRepository {
    public List<Language> getAllLanguages();    
}
