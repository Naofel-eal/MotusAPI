package com.naofeleal.motusAPI.infrastructure.client.controller;

import com.naofeleal.motusAPI.core.application.usecase.interfaces.IFetchWordUseCase;
import com.naofeleal.motusAPI.core.application.usecase.interfaces.IValidateWordUseCase;
import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.core.domain.model.Word;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IFetchWordPresenter;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@Validated
public class WordController {
    private IFetchWordUseCase _fetchWordUseCase;
    private IValidateWordUseCase _validateWordUseCase;
    private IFetchWordPresenter _fetchWordPresenter;

    public WordController(
            IFetchWordUseCase fetchWordUseCase,
            IValidateWordUseCase validateWordUseCase,
            IFetchWordPresenter fetchWordPresenter
    ) {
        this._fetchWordUseCase = fetchWordUseCase;
        this._validateWordUseCase = validateWordUseCase;
        this._fetchWordPresenter = fetchWordPresenter;
    }

    @GetMapping(path = "/fetch/{isocode}/{numberOfWords}")
    public ResponseEntity<Map<String, Object>> fetchWords(
            @PathVariable(value = "isocode") 
            @Pattern(regexp = "^[A-Za-z]{2}$", message = "Language isocode should contains 2 letters.") 
            final String isoCode,
            
            @PathVariable(value = "numberOfWords") 
            @Positive(message = "Number of words should be positive")
            final short numberOfWords
    ) {
        Language language = new Language(isoCode);
        List<Word> words = this._fetchWordUseCase.execute(language, numberOfWords);

        Map<String, Object> response = this._fetchWordPresenter.present(words);

        return ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(response);
    }

    @GetMapping("/validate/{isocode}/{word}")
    public ResponseEntity<Void> validateWord(
        @PathVariable(value = "isocode")
        @Pattern(regexp = "^[A-Za-z]{2}$", message = "Language isocode should contains 2 letters.")
        final String isocode,

        @PathVariable(value = "word")
        @Pattern(regexp = "[A-Za-z]+", message = "The Word should only contains letters.")
        final String word
    ) {
        Language language = new Language(isocode);
        Word testeWord = new Word(word, language);
        boolean isWordValid = this._validateWordUseCase.execute(testeWord, language);

        HttpStatus status = isWordValid ? HttpStatus.FOUND : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).build();
    }
}
