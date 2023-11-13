package com.naofeleal.MotusAPI.Application.IPresenters;

import java.util.List;

import com.naofeleal.MotusAPI.Domain.Entities.Word;

public interface IFetchRandomWordsPresenter {
    void present(List<Word> words);
}
