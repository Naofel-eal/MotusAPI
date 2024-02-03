package com.naofeleal.motusAPI.infrastructure.client.model;

public class ValidationRequestDTO {
    public String word;
    public String languageIsoCode;

    public ValidationRequestDTO(String word, String languageIsoCode) {
        this.word = word;
        this.languageIsoCode = languageIsoCode;
    }
}
