package com.naofeleal.MotusAPI.Infrastructure.Database.Mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.naofeleal.MotusAPI.Domain.Entities.Word;
import com.naofeleal.MotusAPI.Infrastructure.Database.Entities.WordDBO;

@Mapper(componentModel = "spring")
public interface WordDBOMapper {
    Word toDomainEntity(WordDBO wordDBO);
    WordDBO toDBO(Word word);
    List<Word> toDomainEntities(List<WordDBO> wordDBOs);
}
