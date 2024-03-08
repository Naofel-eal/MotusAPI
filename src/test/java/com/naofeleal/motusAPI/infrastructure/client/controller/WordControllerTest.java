package com.naofeleal.motusAPI.infrastructure.client.controller;

import com.naofeleal.motusAPI.core.application.usecase.interfaces.IFetchWordUseCase;
import com.naofeleal.motusAPI.core.application.usecase.interfaces.IValidateWordUseCase;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IFetchWordPresenter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyShort;
import static org.mockito.Mockito.*;

@WebMvcTest(WordController.class)
@ExtendWith(MockitoExtension.class)
public class WordControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IFetchWordUseCase fetchWordUseCase;

    @MockBean
    private IValidateWordUseCase validateWordUseCase;

    @MockBean
    private IFetchWordPresenter fetchWordPresenter;

    @Test
    public void fetchWordShouldValidateIsoCodePattern() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fetch?isocode=a1&numberOfWords=1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(MockMvcRequestBuilders.get("/fetch?isocode=aaa&numberOfWords=1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void fetchWordShouldValidateNumberOfWordsPositive() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fetch?isocode=aa&numberOfWords=0"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

        mockMvc.perform(MockMvcRequestBuilders.get("/fetch?isocode=aa&numberOfWords=-5"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    public void validateWordShouldValidateIsoCodePattern() throws Exception {
        when(validateWordUseCase.execute(any(Word.class), any(Language.class))).thenReturn(true);
        
        mockMvc.perform(MockMvcRequestBuilders.get("/validate?isocode=a1&word=a"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        
        mockMvc.perform(MockMvcRequestBuilders.get("/validate?isocode=EN&word=word"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void validateWordShouldValidateWordPattern() throws Exception {
        when(validateWordUseCase.execute(any(Word.class), any(Language.class))).thenReturn(true);
    
        mockMvc.perform(MockMvcRequestBuilders.get("/validate?isocode=EN&word=1"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
        
        mockMvc.perform(MockMvcRequestBuilders.get("/validate?isocode=EN&word=valid"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void fetchWordsShouldReturnCorrectResponse() throws Exception {
        List<Word> words = Arrays.asList(new Word("hello", new Language("EN")), new Word("world", new Language("EN")));
        when(fetchWordUseCase.execute(any(Language.class), anyShort())).thenReturn(words);

        Map<String, Object> response = new HashMap<>();
        response.put("words", Arrays.asList("hello", "world"));
        when(fetchWordPresenter.present(anyList())).thenReturn(response);

        mockMvc.perform(MockMvcRequestBuilders.get("/fetch?isocode=EN&number=2")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.words").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.words[0]").value("hello"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.words[1]").value("world"));
    }

    @Test
    public void validateWordShouldReturnNotFoundWhenWordIsInvalid() throws Exception {
        when(validateWordUseCase.execute(any(Word.class), any(Language.class))).thenReturn(false);

        mockMvc.perform(MockMvcRequestBuilders.get("/validate?isocode=EN&word=invalidword")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void validateWordShouldReturnOkWhenWordIsValid() throws Exception {
        when(validateWordUseCase.execute(any(Word.class), any(Language.class))).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.get("/validate?isocode=EN&word=validword")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
