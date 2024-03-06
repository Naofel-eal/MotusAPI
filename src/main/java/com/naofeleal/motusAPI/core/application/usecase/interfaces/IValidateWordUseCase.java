package com.naofeleal.motusAPI.core.application.usecase.interfaces;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

public interface IValidateWordUseCase {
    public boolean execute(Word word, Language language);
}
