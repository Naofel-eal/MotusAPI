package com.naofeleal.MotusAPI.Application.Presenters;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import com.naofeleal.MotusAPI.Application.Mappers.OutputWordMapper;
import com.naofeleal.MotusAPI.Application.Mappers.OutputWordMapperImpl;
import com.naofeleal.MotusAPI.Domain.Entities.Word;
import com.naofeleal.MotusAPI.Interfaces.Web.DTOs.OutputWordDTO;

@SpringBootTest(classes = OutputWordMapperImpl.class)
public class GenerateRandomWordsPresenterTest {
    private GenerateRandomWordsPresenter _presenter;
    private OutputWordMapper _outputWordMapper;

    @BeforeEach()
    public void setUp() {
        _outputWordMapper = Mappers.getMapper(OutputWordMapper.class);
        _presenter = new GenerateRandomWordsPresenter(_outputWordMapper);
    }

    @Test
    void it_should_serialize_the_words() {
        // Arrange
        ArrayList<Word> words = new ArrayList<>();
        Word word1 = new Word("word1", "fr-FR");
        words.add(word1);
        List<OutputWordDTO> expectedResult = _outputWordMapper.toOutputWords(words);

        // Act
        _presenter.present(words);     
    
        // Assert
        Assertions.assertEquals(expectedResult, _presenter.result);
    }
}
