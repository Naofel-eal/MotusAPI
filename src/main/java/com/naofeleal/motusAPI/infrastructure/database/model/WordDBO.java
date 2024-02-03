package com.naofeleal.motusAPI.infrastructure.database.model;

import com.naofeleal.motusAPI.core.domain.model.Language;

public class WordDBO {
    public Long id;
    public String value;
    public Language language;

    public WordDBO(Long id, String value, Language language) {
        this.id = id;
        this.value = value;
        this.language = language;
    }
}
