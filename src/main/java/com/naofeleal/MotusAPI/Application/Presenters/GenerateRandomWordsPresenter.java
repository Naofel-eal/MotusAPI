package com.naofeleal.MotusAPI.Application.Presenters;

import java.util.List;

import com.naofeleal.MotusAPI.Application.IPresenters.IGenerateRandomWordsPresenter;
import com.naofeleal.MotusAPI.Application.Mappers.OutputWordMapper;
import com.naofeleal.MotusAPI.Domain.Entities.Word;
import com.naofeleal.MotusAPI.Interfaces.Web.DTOs.OutputWordDTO;

public class GenerateRandomWordsPresenter implements IGenerateRandomWordsPresenter {
    public List<OutputWordDTO> result;
    private OutputWordMapper _outputWordMapper;

    public GenerateRandomWordsPresenter(OutputWordMapper outputWordMapper) {
        this._outputWordMapper = outputWordMapper;
    }

    public void present(List<Word> words) {
        result = _outputWordMapper.toOutputWords(words);
    }
}
