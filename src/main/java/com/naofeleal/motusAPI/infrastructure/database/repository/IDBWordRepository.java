package com.naofeleal.motusAPI.infrastructure.database.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.naofeleal.motusAPI.infrastructure.database.model.WordDBO;

@Repository
public interface IDBWordRepository extends JpaRepository<WordDBO, Long> {
}
