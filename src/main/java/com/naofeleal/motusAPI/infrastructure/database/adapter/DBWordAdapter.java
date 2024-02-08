package com.naofeleal.motusAPI.infrastructure.database.adapter;

import com.naofeleal.motusAPI.core.application.repository.IWordRepository;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

import java.util.List;

public class DBWordAdapter implements IWordRepository {
    @Override
    public List<Word> fetchWords(Language language, short nomberOfWords) {
        return null;
    }

    @Override
    public Boolean validateWord(Word word, Language language) {
        return null;
    }
}
