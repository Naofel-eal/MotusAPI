package com.naofeleal.MotusAPI.Infrastructure.Database.Mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import com.naofeleal.MotusAPI.Domain.Entities.Word;
import com.naofeleal.MotusAPI.Infrastructure.Database.Entities.WordDBO;

@SpringBootTest(classes = WordDBOMapperImpl.class)
public class WordDBOMapperTest {
    private WordDBOMapper _mapper;

    @BeforeEach
    public void setUp() {
        _mapper = Mappers.getMapper(WordDBOMapper.class);
    }

    @Test()
    public void it_should_map_the_input_word_to_domain_word() {
        // Arrange
        String value = "word";
        String languageCode = "en-US";

        WordDBO wordDBO = new WordDBO(value, languageCode);
        Word expectedResult = new Word(value, languageCode); 

        // Act
        Word result = _mapper.toDomainEntity(wordDBO);

        // Assert
        Assertions.assertEquals(expectedResult, result);
    }
}
