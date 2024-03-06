package com.naofeleal.motusAPI.infrastructure.client.mapper;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.infrastructure.client.model.LanguageClientRequestDTO;
import com.naofeleal.motusAPI.infrastructure.client.model.LanguageClientResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IClientLanguageMapper {
    LanguageClientResponseDTO fromDomainModel(Language language);
    Language toDomainModel(LanguageClientRequestDTO languageDTO);
    List<LanguageClientResponseDTO> fromDomainModels(List<Language> languages);
    List<Language> toDomainModels(List<LanguageClientRequestDTO> languagesDTO);
}
