package com.naofeleal.MotusAPI.Domain.Entities;

import java.util.Objects;

public class Word {
    public int length;
    public String languageCode;
    public String value;

    public Word(String value, String languageCode) {
        this.value = value;
        this.languageCode = languageCode;
        this.length = this.value.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return length == word.length &&
            Objects.equals(languageCode, word.languageCode) &&
            Objects.equals(value, word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, languageCode, value);
    }

}
