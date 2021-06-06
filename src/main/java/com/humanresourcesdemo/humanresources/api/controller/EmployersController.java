package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.EmployerService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.Employer;
import com.humanresourcesdemo.humanresources.entities.concretes.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController extends BaseController<EmployerService,Employer> {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        super(employerService);
        this.employerService = employerService;
    }


}
