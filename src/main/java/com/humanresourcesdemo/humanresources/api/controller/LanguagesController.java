package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.LanguageService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController extends BaseController<LanguageService, Language> {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        super(languageService);
        this.languageService = languageService;
    }
}
