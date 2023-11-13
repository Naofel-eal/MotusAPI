package com.naofeleal.MotusAPI.Application.UseCases;

import java.util.List;

import com.naofeleal.MotusAPI.Application.IPresenters.IGenerateRandomWordsPresenter;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

public class SpyWordPresenter implements IGenerateRandomWordsPresenter{
    public boolean isPresenterCalled = false;

    @Override
    public void present(List<Word> words) {
        isPresenterCalled = true;
    }
    
}
