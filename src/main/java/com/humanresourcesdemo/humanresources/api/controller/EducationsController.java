package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.EducationService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/educations")
public class EducationsController extends BaseController<EducationService, Education> {

    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        super(educationService);
        this.educationService = educationService;
    }
}
