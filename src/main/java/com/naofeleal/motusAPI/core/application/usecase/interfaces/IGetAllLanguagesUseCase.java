package com.naofeleal.motusAPI.core.application.usecase.interfaces;

import java.util.List;
import com.naofeleal.motusAPI.core.domain.model.Language;

public interface IGetAllLanguagesUseCase {
    public List<Language> execute();
}
