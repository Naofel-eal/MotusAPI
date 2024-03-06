package com.naofeleal.motusAPI.core.application.usecase;

import com.naofeleal.motusAPI.core.application.repository.IWordRepository;
import com.naofeleal.motusAPI.core.application.usecase.interfaces.IValidateWordUseCase;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

import org.springframework.stereotype.Service;

@Service
public class ValidateWordUseCase implements IValidateWordUseCase {
    private IWordRepository _repository;

    public ValidateWordUseCase(IWordRepository repository) {
        this._repository = repository;
    }

    @Override
    public boolean execute(Word word, Language language) {
        return _repository.validateWord(word, language);
    }
}
