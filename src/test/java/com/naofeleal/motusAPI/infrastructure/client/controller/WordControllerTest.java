package com.naofeleal.motusAPI.infrastructure.client.controller;

import com.naofeleal.motusAPI.core.application.usecase.interfaces.IFetchWordUseCase;
import com.naofeleal.motusAPI.core.application.usecase.interfaces.IValidateWordUseCase;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;
import com.naofeleal.motusAPI.infrastructure.client.mapper.IClientWordMapper;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IFetchWordPresenter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebMvcTest(WordController.class)
@ExtendWith(MockitoExtension.class)
public class WordControllerTest {
    @InjectMocks
    private WordController _wordController;
    @MockBean
    private IClientWordMapper _clientWordMapper;
    @MockBean
    private IFetchWordUseCase _fetchWordUseCase;
    @MockBean
    private IValidateWordUseCase _validateWordUseCase;
    @MockBean
    private IFetchWordPresenter _fetchWordPresenter;
    @Autowired
    private MockMvc _mockMvc;

    @Test
    public void fetchWordShouldValidateIsoCodePattern() throws Exception {
        this._mockMvc.perform(MockMvcRequestBuilders.get("/fetch/a1/1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        this._mockMvc.perform(MockMvcRequestBuilders.get("/fetch//1"))
                .andExpect(MockMvcResultMatchers.status().isNotFound()); 

        this._mockMvc.perform(MockMvcRequestBuilders.get("/fetch/aaa/1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        this._mockMvc.perform(MockMvcRequestBuilders.get("/fetch/a/1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void fetchWordShouldValidateNumberOfWordsPositive() throws Exception {
        this._mockMvc.perform(MockMvcRequestBuilders.get("/fetch/aa/0"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        this._mockMvc.perform(MockMvcRequestBuilders.get("/fetch/aa/-5"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void fetchWordShouldPassWithValidParameters() throws Exception {
        this._mockMvc.perform(MockMvcRequestBuilders.get("/fetch/aa/5"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void fetchWordsShouldCallAllDependencies() {
        // Arrange
        String isoCode = "EN";
        short numberOfWords = 5;

        // Act
        ResponseEntity< Map<String, Object>> response = this._wordController.fetchWords(isoCode, numberOfWords);

        // Assert
        verify(this._fetchWordUseCase, times(1)).execute(any(Language.class), anyShort()); 
        verify(this._fetchWordPresenter, times(1)).present(any());
    }

    @Test
    public void fetchWordsShouldReturnTwoWords() throws Exception {
        Language language = new Language("EN");
        List<Word> exampleWords = Arrays.asList(new Word("test", language), new Word("motus", language));
        when(this._fetchWordUseCase.execute(any(Language.class), anyShort())).thenReturn(exampleWords);

        Map<String, Object> response = new HashMap<>();
        response.put("words", Arrays.asList("test", "motus"));
        when(this._fetchWordPresenter.present(anyList())).thenReturn(response);

        this._mockMvc.perform(MockMvcRequestBuilders.get("/fetch/EN/2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.words").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.words[0]").value("test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.words[1]").value("motus"));
    }

    @Test
    public void validateWordShouldValidateIsoCodePattern() throws Exception {
        this._mockMvc.perform(MockMvcRequestBuilders.get("/validate/a1/a"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        this._mockMvc.perform(MockMvcRequestBuilders.get("/validate/1/a"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        
        this._mockMvc.perform(MockMvcRequestBuilders.get("/validate/aaa/a"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        
        this._mockMvc.perform(MockMvcRequestBuilders.get("/validate//a"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void validateWordShouldValidateWordPattern() throws Exception {
        this._mockMvc.perform(MockMvcRequestBuilders.get("/validate/EN/1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        
        this._mockMvc.perform(MockMvcRequestBuilders.get("/validate/EN/-"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        
        this._mockMvc.perform(MockMvcRequestBuilders.get("/validate/EN//"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void validateWordsShouldCallAllDependencies() {
        // Arrange
        String isoCode = "EN";
        String word = "test";

        // Act
        ResponseEntity<Void> response = this._wordController.validateWord(isoCode, word);

        // Assert
        verify(this._validateWordUseCase, times(1)).execute(any(Word.class), any(Language.class)); 
    }

    @Test
    public void validateWordShouldReturnNotFoundWhenWordIsInvalid() throws Exception {
        String isoCode = "EN";
        String word = "invalidword";
        when(this._validateWordUseCase.execute(any(Word.class), any(Language.class))).thenReturn(false);

        this._mockMvc.perform(MockMvcRequestBuilders.get("/validate/{isocode}/{word}", isoCode, word)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void validateWordShouldReturnFoundWhenWordIsValid() throws Exception {
        String isoCode = "EN";
        String word = "validword";
        when(this._validateWordUseCase.execute(any(Word.class), any(Language.class))).thenReturn(true);

        this._mockMvc.perform(MockMvcRequestBuilders.get("/validate/{isocode}/{word}", isoCode, word)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isFound());
    }
}