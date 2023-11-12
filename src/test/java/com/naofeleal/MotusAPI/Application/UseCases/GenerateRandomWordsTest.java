package com.naofeleal.MotusAPI.Application.UseCases;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import com.naofeleal.MotusAPI.Application.Presenters.GenerateRandomWordsPresenter;

public class GenerateRandomWordsTest {
    private GenerateRandomWords _generateRandomWords;

    @Test()
    public void it_should_call_repository() {
        // Arrange
        SpyWordRepository spyWordRepository = new SpyWordRepository();
        GenerateRandomWordsPresenter presenter = new GenerateRandomWordsPresenter();
        _generateRandomWords = new GenerateRandomWords(spyWordRepository, presenter);
        
        // Act
        _generateRandomWords.execute(5);
        
        // Assert
        Assertions.assertEquals(spyWordRepository.isGenerateRandomWordsCalled, true);
    }

    public void it_should_fetch_words() {
        // TODO
    }
}
