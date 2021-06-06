package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.CompanyService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompaniesController extends BaseController<CompanyService, Company> {

    private CompanyService companyService;

    @Autowired
    public CompaniesController(CompanyService companyService) {
        super(companyService);
        this.companyService = companyService;
    }
}
