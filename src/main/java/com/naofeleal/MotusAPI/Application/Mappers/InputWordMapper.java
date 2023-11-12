package com.naofeleal.MotusAPI.Application.Mappers;

import org.mapstruct.Mapper;

import com.naofeleal.MotusAPI.Domain.Entities.Word;
import com.naofeleal.MotusAPI.Interfaces.Web.DTOs.InputWordDTO;

@Mapper(componentModel = "spring")
public interface InputWordMapper {
    public Word toDomainEntity(InputWordDTO inputWordDTO);

    default int mapLength(String value) {
        return value != null ? value.length() : 0;
    }
}
