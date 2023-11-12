package com.naofeleal.MotusAPI.Application.UseCases;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import com.naofeleal.MotusAPI.Application.Mappers.OutputWordMapper;
import com.naofeleal.MotusAPI.Application.Mappers.OutputWordMapperImpl;
import com.naofeleal.MotusAPI.Application.Presenters.GenerateRandomWordsPresenter;

@SpringBootTest(classes = OutputWordMapperImpl.class)
public class GenerateRandomWordsTest {
    private GenerateRandomWords _generateRandomWords;
    private GenerateRandomWordsPresenter _presenter;

    @BeforeEach()
    public void setUp() {
        OutputWordMapper outputWordMapper = Mappers.getMapper(OutputWordMapper.class);
        _presenter = new GenerateRandomWordsPresenter(outputWordMapper);
    }

    @Test()
    public void it_should_call_repository() {
        // Arrange
        SpyWordRepository spyWordRepository = new SpyWordRepository();
        _generateRandomWords = new GenerateRandomWords(spyWordRepository, _presenter);
        
        // Act
        _generateRandomWords.execute(5);
        
        // Assert
        Assertions.assertEquals(spyWordRepository.isGenerateRandomWordsCalled, true);
    }

    public void it_should_fetch_words() {
        // TODO
    }
}
