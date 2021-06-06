package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.WorkExperienceService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workexperiences")
public class WorkExperiencesController extends BaseController<WorkExperienceService, WorkExperience> {

    private WorkExperienceService workExperienceService;

    @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        super(workExperienceService);
        this.workExperienceService = workExperienceService;
    }
}
