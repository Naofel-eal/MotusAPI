package com.naofeleal.MotusAPI.Application.Presenters;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;

import com.naofeleal.MotusAPI.Application.Mappers.InputWordMapperImpl;

@SpringBootTest(classes = InputWordMapperImpl.class)
public class ValidateWordPresenterTest {
    @Test()
    public void it_should_() {
        // Arrange
        ValidateWordPresenter presenter = new ValidateWordPresenter();
        boolean repositoryResult = true;
        boolean expectedResult = true;

        // Act
        presenter.present(repositoryResult);

        // Assert
        Assertions.assertEquals(expectedResult, presenter.result);
    }
}