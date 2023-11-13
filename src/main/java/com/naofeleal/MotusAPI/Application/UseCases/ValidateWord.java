package com.naofeleal.MotusAPI.Application.UseCases;

import com.naofeleal.MotusAPI.Application.IPresenters.IValidateWordPresenter;
import com.naofeleal.MotusAPI.Application.IRepositories.IWordRepository;
import com.naofeleal.MotusAPI.Application.IUseCases.IValidateWord;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

public class ValidateWord implements IValidateWord {
    private IWordRepository _repository;
    public IValidateWordPresenter presenter;

    public ValidateWord(IWordRepository wordRepository, IValidateWordPresenter presenter) {
        this._repository = wordRepository;
        this.presenter = presenter;
    }

    @Override
    public void execute(Word word) {
        boolean repositoryResult = this._repository.isValid(word);
        presenter.present(repositoryResult);
    }
}
