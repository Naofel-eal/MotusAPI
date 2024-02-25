package com.naofeleal.motusAPI.infrastructure.database.adapter;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;
import com.naofeleal.motusAPI.infrastructure.database.mapper.IDBWordMapper;
import com.naofeleal.motusAPI.infrastructure.database.model.LanguageDBO;
import com.naofeleal.motusAPI.infrastructure.database.model.WordDBO;
import com.naofeleal.motusAPI.infrastructure.database.repository.IDBWordRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class DBWordAdapterTest {
    @Mock
    private IDBWordRepository _wordRepository;

    @Mock
    private IDBWordMapper _dbWordMapper;

    @InjectMocks
    private DBWordAdapter _dbWordAdapter;

    @Test
    public void fetchWordsShouldCallRepositoryWithCorrectParameters() {
        // Arrange
        short numberOfWords = 1;
        String isoCode = "EN";
        Language language = new Language(isoCode);
        List<WordDBO> wordDBOs = List.of(new WordDBO(0L, "test", new LanguageDBO(isoCode)));

        Mockito.when(_wordRepository.findRandomWordsByLanguageIsoCode(isoCode, numberOfWords)).thenReturn(wordDBOs);

        // Act
        _dbWordAdapter.fetchWords(language, numberOfWords);

        // Assert
        Mockito.verify(_wordRepository).findRandomWordsByLanguageIsoCode(isoCode, numberOfWords);
    }

    @Test
    public void fetchWordsShouldCorrectlyMapDBOToDomainModel() {
        // Arrange
        String isoCode = "EN";
        LanguageDBO languageDBO = new LanguageDBO(isoCode);
        WordDBO wordDBO = new WordDBO(0L, "test", languageDBO);
        List<WordDBO> wordDBOs = List.of(wordDBO);
        Language language = new Language(isoCode);
        Word expectedWord = new Word("test", language);
        List<Word> expectedWords = List.of(expectedWord);

        Mockito.when(_wordRepository.findRandomWordsByLanguageIsoCode(isoCode, (short) 1)).thenReturn(wordDBOs);
        Mockito.when(_dbWordMapper.toDomainModels(wordDBOs)).thenReturn(expectedWords);

        // Act
        List<Word> result = _dbWordAdapter.fetchWords(language, (short) 1);

        // Assert
        Assertions.assertEquals(expectedWords, result);
        Mockito.verify(_dbWordMapper).toDomainModels(wordDBOs);
    }

    @Test
    public void fetchWordsShouldReturnConsistentData() {
        // Arrange
        String isoCode = "EN";
        Language language = new Language(isoCode);
        List<WordDBO> wordDBOs = List.of(new WordDBO(0L, "test", new LanguageDBO(isoCode)));
        List<Word> mockedWords = List.of(new Word("test", language));

        Mockito.when(_wordRepository.findRandomWordsByLanguageIsoCode(isoCode, (short) 1)).thenReturn(wordDBOs);
        Mockito.when(_dbWordMapper.toDomainModels(wordDBOs)).thenReturn(mockedWords);

        // Act
        List<Word> result = _dbWordAdapter.fetchWords(language, (short) 1);

        // Assert
        Assertions.assertFalse(result.isEmpty(), "La liste retournée ne devrait pas être vide");
        Assertions.assertEquals("test", result.getFirst().value, "Le mot retourné doit correspondre à l'attendu");
        Assertions.assertEquals(isoCode, result.getFirst().language.isoCode, "Le code ISO de la langue du mot retourné doit correspondre à l'attendu");
    }
}