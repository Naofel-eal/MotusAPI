package com.naofeleal.motusAPI.core.application.repository;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

import java.util.List;

public interface IWordRepository {
    public List<Word> fetchWords(Language language, short numberOfWords);

    public Boolean validateWord(Word word, Language language);
}
