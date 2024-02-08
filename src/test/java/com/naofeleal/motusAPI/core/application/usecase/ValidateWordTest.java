package com.naofeleal.motusAPI.core.application.usecase;

import com.naofeleal.motusAPI.core.application.repository.IWordRepository;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidateWordTest {
    @Mock
    private IWordRepository _repository;

    @InjectMocks
    private ValidateWord _validateWordUseCase;

    @Test
    public void shouldCallTheRepository() {
        // Arrange
        Language language = new Language("EN");
        Word word = new Word("test", language);
        Mockito.when(_repository.validateWord(word, language)).thenReturn(true);

        // Act
        _validateWordUseCase.execute(word, language);

        // Arrange
        Mockito.verify(_repository, Mockito.times(1)).validateWord(word, language);
    }

    @Test
    public void shouldReturnRepositoryOutput() {
        // Arrange
        Language language = new Language("EN");
        Word word = new Word("test", language);
        boolean expectedResult = true;
        Mockito.when(_repository.validateWord(word, language)).thenReturn(expectedResult);

        // Act
        boolean result = _validateWordUseCase.execute(word, language);

        // Arrange
        Assertions.assertEquals(expectedResult, result);
    }
}