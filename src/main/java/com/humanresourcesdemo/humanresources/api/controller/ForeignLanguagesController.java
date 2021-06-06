package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.ForeignLanguageService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguagesController extends BaseController<ForeignLanguageService, ForeignLanguage> {

    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguagesController(ForeignLanguageService foreignLanguageService) {
        super(foreignLanguageService);
        this.foreignLanguageService = foreignLanguageService;
    }
}
