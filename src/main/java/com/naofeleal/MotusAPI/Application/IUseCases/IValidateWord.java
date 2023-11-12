package com.naofeleal.MotusAPI.Application.IUseCases;

import com.naofeleal.MotusAPI.Application.Presenters.ValidateWordPresenter;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

public interface IValidateWord {
    public void execute(Word word, ValidateWordPresenter presenter);
}
