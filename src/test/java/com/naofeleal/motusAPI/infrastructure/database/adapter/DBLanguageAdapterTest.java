package com.naofeleal.motusAPI.infrastructure.database.adapter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;
import com.naofeleal.motusAPI.infrastructure.database.mapper.IDBLanguageMapper;
import com.naofeleal.motusAPI.infrastructure.database.model.LanguageDBO;
import com.naofeleal.motusAPI.infrastructure.database.model.WordDBO;
import com.naofeleal.motusAPI.infrastructure.database.repository.IDBLanguageRepository;

@ExtendWith(MockitoExtension.class)
public class DBLanguageAdapterTest {
    @Mock
    private IDBLanguageRepository _languageRepository;

    @Mock
    private IDBLanguageMapper _dbLanguageMapper;

    @InjectMocks
    private DBLanguageAdapter _dbLanguageAdapter;

    @Test
    public void getAllLanguagesShouldCorrectlyMapDBOToDomainModel() {
        // Arrange
        LanguageDBO languageDBO = new LanguageDBO("FR");
        List<LanguageDBO> languageDBOs = List.of(languageDBO);
        Language expectedLanguage = new Language("FR");
        List<Language> expectedLanguages = List.of(expectedLanguage);

        Mockito.when(_languageRepository.findAll()).thenReturn(languageDBOs);
        Mockito.when(_dbLanguageMapper.toDomainModels(languageDBOs)).thenReturn(expectedLanguages);

        // Act
        List<Language> result = _dbLanguageAdapter.getAllLanguages();

        // Assert
        Assertions.assertEquals(expectedLanguages, result);
        Mockito.verify(_dbLanguageMapper).toDomainModels(languageDBOs);
    }

    @Test
    public void getAllLanguagesShouldReturnConsistentData() {
        // Arrange
        List<LanguageDBO> languageDBOs = Arrays.asList(new LanguageDBO[] {
            new LanguageDBO(0L, "FR"),
            new LanguageDBO(0L, "EN")
        });
        List<Language> mockedLanguages = Arrays.asList(new Language[] {
            new Language("FR"),
            new Language("EN")
        });

        Mockito.when(_languageRepository.findAll()).thenReturn(languageDBOs);
        Mockito.when(_dbLanguageMapper.toDomainModels(languageDBOs)).thenReturn(mockedLanguages);

        // Act
        List<Language> result = _dbLanguageAdapter.getAllLanguages();

        // Assert
        Assertions.assertFalse(result.isEmpty(), "La liste retournée ne devrait pas être vide");
        Assertions.assertEquals("FR", result.getFirst().isoCode, "Le premier isocode doit etre FR.");
        Assertions.assertEquals("EN", result.get(1).isoCode , "Le deuxieme isocode doit etre EN.");
    }
}
