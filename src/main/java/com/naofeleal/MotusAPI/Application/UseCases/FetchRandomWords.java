package com.naofeleal.MotusAPI.Application.UseCases;

import java.util.List;

import org.springframework.stereotype.Service;

import com.naofeleal.MotusAPI.Application.IPresenters.IFetchRandomWordsPresenter;
import com.naofeleal.MotusAPI.Application.IRepositories.IWordRepository;
import com.naofeleal.MotusAPI.Application.IUseCases.IFetchRandomWords;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

@Service
public class FetchRandomWords implements IFetchRandomWords {
    private IWordRepository wordRepository;
    private IFetchRandomWordsPresenter presenter;

    public FetchRandomWords(IWordRepository wordRepository, IFetchRandomWordsPresenter generateRandomWordsPresenter) {
        this.wordRepository = wordRepository;
        this.presenter = generateRandomWordsPresenter;
    }

    @Override
    public void execute(int numberOfWords) {
        List<Word> words = this.wordRepository.fetchRandomWords(numberOfWords);
        this.presenter.present(words);
    }
}
