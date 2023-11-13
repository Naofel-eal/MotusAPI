package com.naofeleal.MotusAPI.Application.UseCases;

import java.util.ArrayList;
import java.util.List;

import com.naofeleal.MotusAPI.Application.IRepositories.IWordRepository;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

public class SpyWordRepository implements IWordRepository {
    public boolean isGenerateRandomWordsCalled = false;
    public boolean isValidCalled = false;

    @Override
    public List<Word> fetchRandomWords(int numberOfWords) {
        isGenerateRandomWordsCalled = true;
        List<Word> words = new ArrayList<Word>();
        words.add(new Word("word", "fr-FR"));
        return words;
    }

    @Override
    public boolean isValid(Word word) {
        isValidCalled = true;
        return false;
    }
}
