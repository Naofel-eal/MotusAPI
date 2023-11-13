package com.naofeleal.MotusAPI.Application.IPresenters;

import java.util.List;

import com.naofeleal.MotusAPI.Domain.Entities.Word;

public interface IGenerateRandomWordsPresenter {
    void present(List<Word> words);
}
