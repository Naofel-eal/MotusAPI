package com.naofeleal.MotusAPI.Application.UseCases;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.naofeleal.MotusAPI.Application.Presenters.ValidateWordPresenter;
import com.naofeleal.MotusAPI.Domain.Entities.Word;

public class ValidateWordTest {

    @Test()
    public void it_should_call_the_repository() {
        // Arrange
        SpyWordRepository spyWordRepository = new SpyWordRepository();
        ValidateWordPresenter presenter = new ValidateWordPresenter();
        ValidateWord validateWord = new ValidateWord(spyWordRepository, presenter);
        Word word = new Word("word", "en-US");
        boolean expectedResult = true;

        // Act
        validateWord.execute(word);

        // Assert
        Assertions.assertEquals(expectedResult, spyWordRepository.isValidCalled);
    }

    @Test()
    public void it_should_give_result_to_presenter() {
        // Arrange
        SpyValidateWordPresenter spyValidateWordPresenter = new SpyValidateWordPresenter();
        ValidateWord validateWord = new ValidateWord(new SpyWordRepository(), spyValidateWordPresenter);
        Word word = new Word("word", "en-US");
        boolean expectedResult = true;

        // Act
        validateWord.execute(word);

        // Assert
        Assertions.assertEquals(expectedResult, spyValidateWordPresenter.isPresentCalled);
    } 
}
