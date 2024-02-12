package com.naofeleal.motusAPI.infrastructure.database.model;

import com.naofeleal.motusAPI.core.domain.model.Language;

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
    public Language language;
    
    public WordDBO(Long id, String value, Language language) {
        this.id = id;
        this.value = value;
        this.language = language;
    }
}
