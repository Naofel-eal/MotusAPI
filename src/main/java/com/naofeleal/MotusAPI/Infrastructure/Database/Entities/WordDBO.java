package com.naofeleal.MotusAPI.Infrastructure.Database.Entities;

import java.util.Objects;

import com.naofeleal.MotusAPI.Domain.Entities.Word;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class WordDBO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String value;
    public String languageCode;

    public WordDBO() {}

    public WordDBO(String Value, String LanguageCode) {
        value = Value;
        languageCode = LanguageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(languageCode, word.languageCode) && Objects.equals(value, word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageCode, value);
    }
}
