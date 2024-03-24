package com.naofeleal.motusAPI.infrastructure.client.presenter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.naofeleal.motusAPI.core.domain.model.Language;

@ExtendWith(MockitoExtension.class)
public class GetAllLanguagesPresenterTest {
    @InjectMocks
    private GetAllLanguagesPresenter _getAllLanguagesPresenter;

    @Test
    public void shouldReturnAMapContainingTheLanguagesList() {
        // Arrange
        List<Language> languages = Arrays.asList(new Language("FR"), new Language("EN"));

        // Act
        Map<String, Object> result = _getAllLanguagesPresenter.present(languages);

        // Assert
        Assertions.assertTrue(result.get("languages") instanceof List, "'languages' should be an instance of List");
        List<String> languageList = (List<String>) result.get("languages");
        Assertions.assertEquals(languages.size(), languageList.size());
        Assertions.assertEquals(languages.get(0).isoCode, languageList.get(0));
        Assertions.assertEquals(languages.get(1).isoCode, languageList.get(1));
    }
}
