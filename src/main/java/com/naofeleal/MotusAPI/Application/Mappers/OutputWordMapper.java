package com.naofeleal.MotusAPI.Application.Mappers;

import java.util.List;
import org.mapstruct.Mapper;

import com.naofeleal.MotusAPI.Domain.Entities.Word;
import com.naofeleal.MotusAPI.Interfaces.Web.DTOs.OutputWordDTO;

@Mapper(componentModel = "spring")
public interface OutputWordMapper {
    public OutputWordDTO toOutputWord(Word word);

    public List<OutputWordDTO> toOutputWords(List<Word> words);
}
