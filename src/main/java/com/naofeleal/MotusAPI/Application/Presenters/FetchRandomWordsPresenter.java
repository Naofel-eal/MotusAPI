package com.naofeleal.MotusAPI.Application.Presenters;

import java.util.List;

import com.naofeleal.MotusAPI.Application.IPresenters.IFetchRandomWordsPresenter;
import com.naofeleal.MotusAPI.Application.Mappers.OutputWordMapper;
import com.naofeleal.MotusAPI.Domain.Entities.Word;
import com.naofeleal.MotusAPI.Interfaces.Web.DTOs.OutputWordDTO;

public class FetchRandomWordsPresenter implements IFetchRandomWordsPresenter {
    public List<OutputWordDTO> result;
    private OutputWordMapper _outputWordMapper;

    public FetchRandomWordsPresenter(OutputWordMapper outputWordMapper) {
        this._outputWordMapper = outputWordMapper;
    }

    public void present(List<Word> words) {
        result = _outputWordMapper.toOutputWords(words);
    }
}
