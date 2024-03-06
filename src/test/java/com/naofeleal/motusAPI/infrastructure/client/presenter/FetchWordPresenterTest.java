package com.naofeleal.motusAPI.infrastructure.client.presenter;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class FetchWordPresenterTest {
    @InjectMocks
    private FetchWordPresenter _fetchWordPresenter;

    @Test
    public void shouldReturnAJSONObjectContainingAnArray() throws JSONException {
        // Arrange
        String languageIsoCode = "EN";
        Language language = new Language(languageIsoCode);
        List<Word> words = Arrays.asList(new Word("test", language), new Word("word", language));

        // Act
        JSONObject result = _fetchWordPresenter.present(words);

        // Assert
        Assertions.assertInstanceOf(JSONArray.class, result.get("words"), "'words' should be an instance of JSONArray");
    }

    @Test
    public void shouldContainTheValuesOfWordList() throws JSONException {
        // Arrange
        String languageIsoCode = "EN";
        Language language = new Language(languageIsoCode);
        List<Word> words = Arrays.asList(new Word("test", language), new Word("word", language));

        // Act
        JSONObject result = _fetchWordPresenter.present(words);
        JSONArray jsonWords = result.getJSONArray("words");

        // Assert
        Assertions.assertEquals(jsonWords.length(), words.size());
        Assertions.assertEquals(words.getFirst().value, jsonWords.get(0));
        Assertions.assertEquals(words.get(1).value, jsonWords.get(1));
    }
}