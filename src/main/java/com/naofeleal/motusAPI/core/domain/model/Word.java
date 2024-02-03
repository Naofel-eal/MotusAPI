package com.naofeleal.motusAPI.core.domain.model;

public class Word {
    public String value;
    public Language language;

    public Word(String value, Language language) {
        this.value = value;
        this.language = language;
    }
}
