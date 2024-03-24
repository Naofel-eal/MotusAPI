package com.naofeleal.motusAPI.core.application.usecase;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naofeleal.motusAPI.core.application.repository.ILanguageRepository;
import com.naofeleal.motusAPI.core.domain.model.Language;

@ExtendWith(MockitoExtension.class)
public class GetAllLanguagesTest {
    @Mock
    private ILanguageRepository _repository;

    @InjectMocks
    private GetAllLanguagesUseCase _getAllLanguagesUseCase;

    @Test
    public void executeShouldCallTheRepository() {
        // Arrange
        Language language = new Language("EN");
        List<Language> result = List.of(language);
        Mockito.when(_repository.getAllLanguages()).thenReturn(result);

        // Act
        _getAllLanguagesUseCase.execute();

        // Assert
        Mockito.verify(_repository, Mockito.times(1)).getAllLanguages();
    }

    @Test
    public void executeShouldReturnRepositoryOutput() {
        // Arrange
        List<Language> expectedResult = Arrays.asList(new Language[] {
            new Language("FR"),
            new Language("EN")
        });
        Mockito.when(_repository.getAllLanguages()).thenReturn(expectedResult);

        // Act
        List<Language> result = _getAllLanguagesUseCase.execute();

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }
}
