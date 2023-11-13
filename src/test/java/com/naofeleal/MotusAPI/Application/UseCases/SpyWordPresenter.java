package com.naofeleal.MotusAPI.Application.UseCases;

import java.util.List;

import com.naofeleal.MotusAPI.Application.IPresenters.IFetchRandomWordsPresenter;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

public class SpyWordPresenter implements IFetchRandomWordsPresenter{
    public boolean areWordsGiven = false;

    @Override
    public void present(List<Word> words) {
        areWordsGiven = words == null ? false : true;
    }
    
}
