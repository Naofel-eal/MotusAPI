package com.naofeleal.motusAPI.core.application.usecase.interfaces;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

import java.util.List;

public interface IFetchWordUseCase {
    public List<Word> execute(Language language, short nomberOfWords);
}
