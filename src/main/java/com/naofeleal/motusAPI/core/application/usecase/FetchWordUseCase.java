package com.naofeleal.motusAPI.core.application.usecase;

import com.naofeleal.motusAPI.core.application.repository.IWordRepository;
import com.naofeleal.motusAPI.core.application.usecase.interfaces.IFetchWordUseCase;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FetchWordUseCase implements IFetchWordUseCase {
    private final IWordRepository _repository;
    public FetchWordUseCase(IWordRepository repository) {
        this._repository = repository;
    }
    @Override
    public List<Word> execute(Language language, short numberOfWords) {
        return this._repository.fetchWords(language, numberOfWords);
    }
}
