package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.SchoolService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController extends BaseController<SchoolService, School> {

    private SchoolService schoolService;

    @Autowired
    public SchoolsController(SchoolService schoolService) {
        super(schoolService);
        this.schoolService = schoolService;
    }

}
