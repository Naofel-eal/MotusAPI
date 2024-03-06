package com.naofeleal.motusAPI.infrastructure.client.model;

public class WordClientRequestDTO {
    public String value;
    public String languageIsoCode;

    public WordClientRequestDTO(String value, String languageIsoCode) {
        this.value = value;
        this.languageIsoCode = languageIsoCode;
    }
}
