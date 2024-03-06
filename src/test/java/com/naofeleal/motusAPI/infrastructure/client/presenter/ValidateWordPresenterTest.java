package com.naofeleal.motusAPI.infrastructure.client.presenter;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ValidateWordPresenterTest {
    @InjectMocks
    private ValidateWordPresenter _validateWordPresenter;

    @Test
    public void shouldReturnAJSONObjectContainingABoolean() throws JSONException {
        // Arrange
        boolean isWordValid = false;

        // Act
        JSONObject result = _validateWordPresenter.present(isWordValid);

        // Assert
        Assertions.assertEquals(result.getBoolean("result"), isWordValid);
    }
}