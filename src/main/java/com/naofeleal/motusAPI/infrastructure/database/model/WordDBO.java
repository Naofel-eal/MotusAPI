package com.naofeleal.motusAPI.infrastructure.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="word")
public class WordDBO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="word_id")
    public Long id;

    @Column(name="word_value", nullable=false)
    public String value;

    @ManyToOne
    @JoinColumn(name="word_language_id", nullable=false)
    public LanguageDBO language;
    
    public WordDBO(Long id, String value, LanguageDBO language) {
        this.id = id;
        this.value = value;
        this.language = language;
    }

    public WordDBO() {
        this.id = null;
        this.value = null;
        this.language = null;
    }
}
