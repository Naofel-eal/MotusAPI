package com.naofeleal.motusAPI.infrastructure.database.adapter;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.naofeleal.motusAPI.core.application.repository.ILanguageRepository;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.infrastructure.database.mapper.IDBLanguageMapper;
import com.naofeleal.motusAPI.infrastructure.database.model.LanguageDBO;
import com.naofeleal.motusAPI.infrastructure.database.repository.IDBLanguageRepository;

@Repository
public class DBLanguageAdapter implements ILanguageRepository{
    private IDBLanguageRepository _languageRepository;
    private IDBLanguageMapper _dbLanguageMapper;

    public DBLanguageAdapter(IDBLanguageRepository languageRepository, IDBLanguageMapper languageMapper) {
        this._languageRepository = languageRepository;
        this._dbLanguageMapper = languageMapper;
    }

    @Override
    public List<Language> getAllLanguages() {
        List<LanguageDBO> languageDBOs = this._languageRepository.findAll();
        return _dbLanguageMapper.toDomainModels(languageDBOs);
    }
}