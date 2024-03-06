package com.naofeleal.motusAPI.infrastructure.client.controller;

import com.naofeleal.motusAPI.core.application.usecase.interfaces.IFetchWordUseCase;
import com.naofeleal.motusAPI.core.application.usecase.interfaces.IValidateWordUseCase;
import com.naofeleal.motusAPI.infrastructure.client.mapper.IClientWordMapper;
import com.naofeleal.motusAPI.infrastructure.client.model.LanguageClientRequestDTO;
import com.naofeleal.motusAPI.infrastructure.client.model.LanguageClientResponseDTO;
import com.naofeleal.motusAPI.infrastructure.client.model.WordClientRequestDTO;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IFetchWordPresenter;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IValidateWordPresenter;
import org.json.JSONObject;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class WordControllerTest {
    @InjectMocks
    private WordController _wordController;
    @Mock
    private IClientWordMapper _clientWordMapper;
    @Mock
    private IFetchWordUseCase _fetchWordUseCase;
    @Mock
    private IValidateWordUseCase _validateWordUseCase;
    @Mock
    private IFetchWordPresenter _fetchWordPresenter;
    @Mock
    private IValidateWordPresenter _validateWordPresenter;

    public void fetchWordsShouldCallTheMapperTheUseCaseThePresenter() {
        // Arrange
        int numberOfWords = 2;
        String languageIsoCode = "EN";

        // Act
        this._wordController.fetchWords(languageIsoCode, numberOfWords);

        // Assert
        
    }
}