package com.naofeleal.motusAPI.infrastructure.database.mapper;

import com.naofeleal.motusAPI.core.domain.model.Language;
import com.naofeleal.motusAPI.infrastructure.database.model.LanguageDBO;

import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IDBLanguageMapper {
    LanguageDBO fromDomainModel(Language language);
    Language toDomainModel(LanguageDBO languageDBO);

    List<LanguageDBO> fromDomainModels(List<Language> languages);
    List<Language> toDomainModels(List<LanguageDBO> languageDBOs);
}
