package com.naofeleal.MotusAPI.Application.UseCases;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import com.naofeleal.MotusAPI.Application.Mappers.OutputWordMapper;
import com.naofeleal.MotusAPI.Application.Mappers.OutputWordMapperImpl;
import com.naofeleal.MotusAPI.Application.Presenters.FetchRandomWordsPresenter;

@SpringBootTest(classes = OutputWordMapperImpl.class)
public class FetchRandomWordsTest {
    private FetchRandomWords _generateRandomWords;
    private FetchRandomWordsPresenter _presenter;

    @BeforeEach()
    public void setUp() {
        OutputWordMapper outputWordMapper = Mappers.getMapper(OutputWordMapper.class);
        _presenter = new FetchRandomWordsPresenter(outputWordMapper);

    }

    @Test()
    public void it_should_call_repository() {
        // Arrange
        SpyWordRepository spyWordRepository = new SpyWordRepository();
        _generateRandomWords = new FetchRandomWords(spyWordRepository, _presenter);
        
        // Act
        _generateRandomWords.execute(5);
        
        // Assert
        Assertions.assertEquals(spyWordRepository.isGenerateRandomWordsCalled, true);
    }

    @Test()
    public void it_should_give_words_to_presenter() {
        // Arrange
        SpyWordPresenter spyWordPresenter = new SpyWordPresenter();
        _generateRandomWords = new FetchRandomWords(new SpyWordRepository(), spyWordPresenter);

        // Act
        _generateRandomWords.execute(5);

        // Assert
        Assertions.assertEquals(spyWordPresenter.areWordsGiven, true);
    }
}
