package com.naofeleal.motusAPI.infrastructure.database.adapter;

import com.naofeleal.motusAPI.core.application.repository.IWordRepository;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

import java.util.List;

import com.naofeleal.motusAPI.infrastructure.database.mapper.IDBWordMapper;
import com.naofeleal.motusAPI.infrastructure.database.model.WordDBO;
import com.naofeleal.motusAPI.infrastructure.database.repository.IDBWordRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DBWordAdapter implements IWordRepository {
    private IDBWordRepository _wordRepository;
    private IDBWordMapper _dbWordMapper;

    public DBWordAdapter(IDBWordRepository wordRepository, IDBWordMapper dbWordMapper) {
        _wordRepository = wordRepository;
        _dbWordMapper = dbWordMapper;
    }

    @Override
    public List<Word> fetchWords(Language language, short numberOfWords) {
        List<WordDBO> databaseResult = this._wordRepository.findRandomWordsByLanguageIsoCode(language.isoCode, numberOfWords);
        return _dbWordMapper.toDomainModels(databaseResult);
    }

    @Override
    public Boolean validateWord(Word word, Language language) {
        return null;
    }
}