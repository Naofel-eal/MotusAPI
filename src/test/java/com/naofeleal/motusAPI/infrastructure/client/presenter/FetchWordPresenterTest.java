package com.naofeleal.motusAPI.infrastructure.client.presenter; 

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class FetchWordPresenterTest {
    @InjectMocks
    private FetchWordPresenter _fetchWordPresenter;

    @Test
    public void shouldReturnAMapContainingAList() {
        // Arrange
        String languageIsoCode = "EN";
        Language language = new Language(languageIsoCode);
        List<Word> words = Arrays.asList(new Word("test", language), new Word("word", language));

        // Act
        Map<String, Object> result = _fetchWordPresenter.present(words);

        // Assert
        Assertions.assertTrue(result.get("words") instanceof List, "'words' should be an instance of List");
        List<String> wordList = (List<String>) result.get("words");
        Assertions.assertEquals(words.size(), wordList.size());
        Assertions.assertEquals(words.get(0).value, wordList.get(0));
        Assertions.assertEquals(words.get(1).value, wordList.get(1));
    }
}
