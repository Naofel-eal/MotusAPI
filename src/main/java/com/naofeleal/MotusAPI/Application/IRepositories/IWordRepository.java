package com.naofeleal.MotusAPI.Application.IRepositories;

import java.util.List;

import com.naofeleal.MotusAPI.Domain.Entities.Word;

public interface IWordRepository {
    public List<Word> fetchRandomWords(int numberOfWords);
    public boolean isValid(Word word);
}
