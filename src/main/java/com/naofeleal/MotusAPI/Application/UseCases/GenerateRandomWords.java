package com.naofeleal.MotusAPI.Application.UseCases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naofeleal.MotusAPI.Application.IPresenters.IGenerateRandomWordsPresenter;
import com.naofeleal.MotusAPI.Application.IRepositories.IWordRepository;
import com.naofeleal.MotusAPI.Application.IUseCases.IGenerateRandomWords;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

@Service
public class GenerateRandomWords implements IGenerateRandomWords {
    private IWordRepository wordRepository;
    private IGenerateRandomWordsPresenter presenter;

    public GenerateRandomWords(IWordRepository wordRepository, IGenerateRandomWordsPresenter generateRandomWordsPresenter) {
        this.wordRepository = wordRepository;
        this.presenter = generateRandomWordsPresenter;
    }

    @Override
    public void execute(int numberOfWords) {
        List<Word> words = this.wordRepository.fetchRandomWords(numberOfWords);
        this.presenter.present(words);
    }
}
