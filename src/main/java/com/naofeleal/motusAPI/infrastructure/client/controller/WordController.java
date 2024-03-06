package com.naofeleal.motusAPI.infrastructure.client.controller;

import com.naofeleal.motusAPI.infrastructure.client.mapper.IClientWordMapper;
import com.naofeleal.motusAPI.core.application.usecase.interfaces.IFetchWordUseCase;
import com.naofeleal.motusAPI.core.application.usecase.interfaces.IValidateWordUseCase;
import com.naofeleal.motusAPI.infrastructure.client.model.WordClientRequestDTO;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IFetchWordPresenter;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IValidateWordPresenter;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class WordController {
    private IClientWordMapper _clientWordMapper;
    private IFetchWordUseCase _fetchWordUseCase;
    private IValidateWordUseCase _validateWordUseCase;
    private IFetchWordPresenter _fetchWordPresenter;
    private IValidateWordPresenter _validateWordPresenter;

    public WordController(
            IClientWordMapper clientWordMapper,
            IFetchWordUseCase fetchWordUseCase,
            IValidateWordUseCase validateWordUseCase,
            IFetchWordPresenter fetchWordPresenter,
            IValidateWordPresenter validateWordPresenter
    ) {
        this._clientWordMapper = clientWordMapper;
        this._fetchWordUseCase = fetchWordUseCase;
        this._validateWordUseCase = validateWordUseCase;
        this._fetchWordPresenter = fetchWordPresenter;
        this._validateWordPresenter = validateWordPresenter;
    }

    @GetMapping("/fetch-words/{isocode}/{n}")
    public ResponseEntity<JSONObject> fetchWords(
            @PathVariable(value = "isocode") final String isoCode,
            @PathVariable(value = "n") final int numberOfWords
    ) {
        return null;
    }

}
