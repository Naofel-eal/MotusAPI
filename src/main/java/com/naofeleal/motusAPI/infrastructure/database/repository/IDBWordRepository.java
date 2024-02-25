package com.naofeleal.motusAPI.infrastructure.database.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.naofeleal.motusAPI.infrastructure.database.model.WordDBO;

import java.util.List;

@Repository
public interface IDBWordRepository extends JpaRepository<WordDBO, Long> {
    @Query(value = "SELECT w.* FROM word w JOIN language l ON w.word_language_id = l.language_id WHERE l.language_iso_code = ?1 ORDER BY RANDOM() LIMIT ?2", nativeQuery = true)
    List<WordDBO> findRandomWordsByLanguageIsoCode(String isoCode, int limit);

    @Query("SELECT COUNT(w) > 0 FROM WordDBO w JOIN w.language l WHERE l.isoCode = :isoCode AND w.value = :value")
    boolean existsByLanguageIsoCodeAndValue(@Param("isoCode") String isoCode, @Param("value") String value);
}
