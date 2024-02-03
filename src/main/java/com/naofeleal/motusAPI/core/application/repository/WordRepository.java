package com.naofeleal.motusAPI.core.application.repository;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

import java.util.List;

public interface WordRepository {
    public List<Word> fetchWords(Language language, short nomberOfWords);

    public Boolean validateWord(Word word, Language language);
}
