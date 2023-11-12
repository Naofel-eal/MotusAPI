package com.naofeleal.MotusAPI.Application.UseCases;

import java.util.List;

import com.naofeleal.MotusAPI.Application.IRepositories.IWordRepository;
import com.naofeleal.MotusAPI.Application.IUseCases.IGenerateRandomWords;
import com.naofeleal.MotusAPI.Application.Presenters.GenerateRandomWordsPresenter;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

public class GenerateRandomWords implements IGenerateRandomWords {
    private IWordRepository wordRepository;
    private GenerateRandomWordsPresenter presenter;

    public GenerateRandomWords(IWordRepository wordRepository, GenerateRandomWordsPresenter generateRandomWordsPresenter) {
        this.wordRepository = wordRepository;
        this.presenter = generateRandomWordsPresenter;
    }

    @Override
    public void execute(int numberOfWords) {
        List<Word> words = this.wordRepository.fetchRandomWords(numberOfWords);
        this.presenter.present(words);
    }
}
