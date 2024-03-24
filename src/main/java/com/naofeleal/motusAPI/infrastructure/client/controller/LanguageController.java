package com.naofeleal.motusAPI.infrastructure.client.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naofeleal.motusAPI.core.application.usecase.interfaces.IGetAllLanguagesUseCase;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IGetAllLanguagesPresenter;

@RestController
public class LanguageController {
     private IGetAllLanguagesUseCase _getAllLanguagesUseCase;
    private IGetAllLanguagesPresenter _getAllLanguagesPresenter;

    public LanguageController(
            IGetAllLanguagesUseCase getAllLanguagesUseCase,
            IGetAllLanguagesPresenter getAllLanguagesPresenter
    ) {
        this._getAllLanguagesUseCase = getAllLanguagesUseCase;
        this._getAllLanguagesPresenter = getAllLanguagesPresenter;
    }

    @GetMapping(path = "/languages")
    public ResponseEntity<Map<String, Object>> getAllLanguages() {
        List<Language> languages = this._getAllLanguagesUseCase.execute();

        Map<String, Object> response = this._getAllLanguagesPresenter.present(languages);

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }
}
