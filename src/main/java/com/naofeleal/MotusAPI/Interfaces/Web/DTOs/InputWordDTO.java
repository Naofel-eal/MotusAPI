package com.naofeleal.MotusAPI.Interfaces.Web.DTOs;

import java.util.Objects;

public class InputWordDTO {
    public String value;
    public String languageCode;

    public InputWordDTO(String value, String languageCode) {
        this.value = value;
        this.languageCode = languageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputWordDTO that = (InputWordDTO) o;
        return Objects.equals(value, that.value) && Objects.equals(languageCode, that.languageCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, languageCode);
    }
}
