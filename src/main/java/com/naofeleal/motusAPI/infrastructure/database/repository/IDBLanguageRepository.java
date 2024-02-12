package com.naofeleal.motusAPI.infrastructure.database.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IDBWordRepository extends JpaRepository<LanguageDBO, Long> {
}
