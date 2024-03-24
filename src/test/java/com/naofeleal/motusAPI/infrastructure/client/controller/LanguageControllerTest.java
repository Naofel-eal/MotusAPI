package com.naofeleal.motusAPI.infrastructure.client.controller;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.naofeleal.motusAPI.core.application.usecase.interfaces.IGetAllLanguagesUseCase;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IGetAllLanguagesPresenter;

@WebMvcTest(LanguageController.class)
@ExtendWith(MockitoExtension.class)
public class LanguageControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IGetAllLanguagesUseCase _getAllLanguagesUseCase;

    @MockBean
    private IGetAllLanguagesPresenter _getAllLanguagesPresenter;

    @Test
    public void getAllLanguagesShouldReturnsAllLanguages() throws Exception {
        List<Language> languages = Arrays.asList(new Language("FR"), new Language("EN"));
        when(_getAllLanguagesUseCase.execute()).thenReturn(languages);

        Map<String, Object> response = new HashMap<>();
        
        response.put("languages", Arrays.asList("FR", "EN"));
        when(_getAllLanguagesPresenter.present(anyList())).thenReturn(response);

         mockMvc.perform(MockMvcRequestBuilders.get("/languages")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.languages").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.languages[0]").value("FR"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.languages[1]").value("EN"));
    }
}
