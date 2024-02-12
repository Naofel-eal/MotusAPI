package com.naofeleal.motusAPI.core.application.usecase.inteface;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

public interface IValidateWord {
    public boolean execute(Word word, Language language);
}
