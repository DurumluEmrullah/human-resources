package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.CurriculumVitaeService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/curriculumvitaes")
public class CurriculumVitaesController extends BaseController<CurriculumVitaeService, CurriculumVitae> {

    private CurriculumVitaeService curriculumVitaeService;

    @Autowired
    public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
        super(curriculumVitaeService);
        this.curriculumVitaeService = curriculumVitaeService;
    }
}
