package com.naofeleal.motusAPI.core.application.usecase;

import com.naofeleal.motusAPI.core.application.repository.IWordRepository;
import com.naofeleal.motusAPI.core.application.usecase.inteface.IValidateWord;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

@Service
public class ValidateWord implements IValidateWord {
    private IWordRepository _repository;

    public ValidateWord(IWordRepository repository) {
        this._repository = repository;
    }

    @Override
    public boolean execute(Word word, Language language) {
        return _repository.validateWord(word, language);
    }
}
