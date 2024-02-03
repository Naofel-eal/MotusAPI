package com.naofeleal.motusAPI.infrastructure.database.model;

public class LanguageDBO {
    public Long id;
    public String isoCode;

    public LanguageDBO(Long id, String isoCode) {
        this.id = id;
        this.isoCode = isoCode;
    }
}
