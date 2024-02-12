package com.naofeleal.motusAPI.infrastructure.database.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import java.util.List;

import com.naofeleal.motusAPI.infrastructure.database.model.WordDBO;

@Entity
@Table(name="language")
public class LanguageDBO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="language_id")
    public Long id;

    @Column(name="language_iso_code", nullable=false, unique=true)
    public String isoCode;

    @OneToMany(mappedBy="language", cascade=CascadeType.ALL, orphanRemoval=true)
    public List<WordDBO> words;

    public LanguageDBO(Long id, String isoCode, List<WordDBO> words) {
        this.id = id;
        this.isoCode = isoCode;
        this.words = words;
    }
}
