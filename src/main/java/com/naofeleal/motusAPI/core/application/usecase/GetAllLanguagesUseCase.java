package com.naofeleal.motusAPI.core.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naofeleal.motusAPI.core.application.repository.ILanguageRepository;
import com.naofeleal.motusAPI.core.application.usecase.interfaces.IGetAllLanguagesUseCase;
import com.naofeleal.motusAPI.core.domain.model.Language;

@Service
public class GetAllLanguagesUseCase implements IGetAllLanguagesUseCase {
    private final ILanguageRepository _repository;

    public GetAllLanguagesUseCase(ILanguageRepository repository) {
        this._repository = repository;
    }

    @Override
    public List<Language> execute() {
        return this._repository.getAllLanguages();
    }
}
