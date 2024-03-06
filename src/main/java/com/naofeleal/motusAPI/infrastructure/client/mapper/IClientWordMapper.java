package com.naofeleal.motusAPI.infrastructure.client.mapper;

import com.naofeleal.motusAPI.core.domain.model.Word;
import com.naofeleal.motusAPI.infrastructure.client.model.WordClientRequestDTO;
import com.naofeleal.motusAPI.infrastructure.client.model.WordClientResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClientWordMapper {
    WordClientResponseDTO fromDomainModels(Word word);
    Word toDomainModel(WordClientRequestDTO wordDTO);
    List<WordClientResponseDTO> fromDomainModels(List<Word> words);
    List<Word> toDomainModels(List<WordClientRequestDTO> wordsDTO);
}
