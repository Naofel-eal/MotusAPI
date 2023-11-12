package com.naofeleal.MotusAPI.Infrastructure.Database.Repositories;

import java.util.List;

import com.naofeleal.MotusAPI.Application.IRepositories.IWordRepository;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

public class WordRepository implements IWordRepository {

    @Override
    public List<Word> fetchRandomWords(int numberOfWords) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateRandomWords'");
    }

    @Override
    public boolean isValid(Word word) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }
}
