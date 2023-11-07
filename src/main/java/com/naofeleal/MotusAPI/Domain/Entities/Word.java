package com.naofeleal.MotusAPI.Domain.Entities;

public class Word {
    private int _length;
    public String languageCode;
    public String value;

    public Word(String value, String languageCode) {
        this.value = value;
        this.languageCode = languageCode;
        this._length = this.value.length();
    }
}
