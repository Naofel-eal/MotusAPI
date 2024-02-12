package com.naofeleal.motusAPI.core.application.usecase.inteface;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

import java.util.List;

public interface IFetchWord {
    public List<Word> execute(Language language, short nomberOfWords);
}
