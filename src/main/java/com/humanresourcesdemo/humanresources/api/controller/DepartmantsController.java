package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.DepartmantService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.Departmant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departmants")
public class DepartmantsController extends BaseController<DepartmantService, Departmant> {

    private DepartmantService departmantService;

    @Autowired
    public DepartmantsController(DepartmantService departmantService) {
        super(departmantService);
        this.departmantService = departmantService;
    }
}
