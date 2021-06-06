package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.LanguageLevelService;
import com.humanresourcesdemo.humanresources.business.abstracts.LanguageService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/languagelevels")
public class LanguageLevelsController extends BaseController<LanguageLevelService, LanguageLevel> {

    private LanguageLevelService languageLevelService;

    @Autowired
    public LanguageLevelsController(LanguageLevelService languageLevelService) {
        super(languageLevelService);
        this.languageLevelService = languageLevelService;
    }
}
