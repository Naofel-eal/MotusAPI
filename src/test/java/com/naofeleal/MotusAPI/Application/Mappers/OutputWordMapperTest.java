package com.naofeleal.MotusAPI.Application.Mappers;

import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import com.naofeleal.MotusAPI.Domain.Entities.Word;
import com.naofeleal.MotusAPI.Interfaces.Web.DTOs.OutputWordDTO;

@SpringBootTest(classes = OutputWordMapperImpl.class)
public class OutputWordMapperTest {
    private OutputWordMapper _outputWordMapper;

    @BeforeEach()
    public void setUp() {
        _outputWordMapper = Mappers.getMapper(OutputWordMapper.class);
    }

    @Test()
    public void it_should_map_the_word_to_output_word() {
        // Arrange
        String value = "word";
        String languageCode = "en-US";

        Word word = new Word(value, languageCode);
        OutputWordDTO expectedResult = new OutputWordDTO(value, languageCode);

        // Act
        OutputWordDTO result = _outputWordMapper.toOutputWord(word);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }

    @Test()
    public void it_should_map_the_words_to_output_words() {
        // Arrange
        String value = "word";
        String languageCode = "en-US";

        Word word = new Word(value, languageCode);
        OutputWordDTO outputWord = new OutputWordDTO(value, languageCode);

        List<Word> words = new ArrayList<>();
        List<OutputWordDTO> expectedResult = new ArrayList<>();
        words.add(word);
        expectedResult.add(outputWord);

        // Act
        List<OutputWordDTO> result = _outputWordMapper.toOutputWords(words);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }
}
