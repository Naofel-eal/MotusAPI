package com.naofeleal.motusAPI.infrastructure.database.mapper;

import com.naofeleal.motusAPI.core.domain.model.Word;
import com.naofeleal.motusAPI.infrastructure.database.model.WordDBO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDBWordMapper {
    WordDBO fromDomainModel(Word word);
    Word toDomainModel(WordDBO wordDBO);

    List<WordDBO> fromDomainModels(List<Word> word);
    List<Word> toDomainModels(List<WordDBO> wordDBOs);
}
