package com.naofeleal.motusAPI.infrastructure.client.presenter;

import com.naofeleal.motusAPI.core.domain.model.Word;
import com.naofeleal.motusAPI.infrastructure.client.presenter.interfaces.IFetchWordPresenter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class FetchWordPresenter implements IFetchWordPresenter {

    public FetchWordPresenter() {}

    @Override
    public Map<String, Object> present(List<Word> words) {
        Map<String, Object> result = new HashMap<>();
        List<String> wordValues = words.stream().map(word -> word.value).collect(Collectors.toList());
        result.put("words", wordValues);
        return result; 
    }
}
