package com.naofeleal.MotusAPI.Application.Mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import com.naofeleal.MotusAPI.Domain.Entities.Word;
import com.naofeleal.MotusAPI.Interfaces.Web.DTOs.InputWordDTO;

@SpringBootTest(classes = InputWordMapperImpl.class)
public class InputWordMapperTest {
    private InputWordMapper _inputWordMapper;

    @BeforeEach()
    public void setUp() {
        _inputWordMapper = Mappers.getMapper(InputWordMapper.class);
    }

    @Test()
    public void it_should_map_the_input_word_to_domain_word() {
        // Arrange
        String value = "word";
        String languageCode = "en-US";

        InputWordDTO inputWordDTO = new InputWordDTO(value, languageCode);
        Word expectedResult = new Word(value, languageCode); 

        // Act
        Word result = _inputWordMapper.toDomainEntity(inputWordDTO);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }
}
