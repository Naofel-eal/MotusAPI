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

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FetchWordTest {
    @Mock
    private IWordRepository _repository;

    @InjectMocks
    private FetchWord _fetchWordUseCase;

    @Test
    public void executeShouldCallTheReository() {
        // Arrange
        Language language = new Language("EN");
        short numberOfWords = 1;
        ArrayList<Word> result = new ArrayList<Word>();
        result.add(new Word("test", language));
        Mockito.when(_repository.fetchWords(language, numberOfWords)).thenReturn(result);

        // Act
        _fetchWordUseCase.execute(language, numberOfWords);

        // Assert
        Mockito.verify(_repository, Mockito.times(1)).fetchWords(language, numberOfWords);
    }

    @Test
    public void executeShouldReturnRepositoryOutput() {
        // Arrange
        Language language = new Language("EN");
        short numberOfWords = 1;
        ArrayList<Word> expectedResult = new ArrayList<Word>();
        expectedResult.add(new Word("test", language));
        Mockito.when(_repository.fetchWords(language, numberOfWords)).thenReturn(expectedResult);

        // Act
        List<Word> result = _fetchWordUseCase.execute(language, numberOfWords);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }
}