package com.naofeleal.motusAPI.infrastructure.database.model;

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

    public LanguageDBO(Long id, String isoCode) {
        this.id = id;
        this.isoCode = isoCode;
    }
}
