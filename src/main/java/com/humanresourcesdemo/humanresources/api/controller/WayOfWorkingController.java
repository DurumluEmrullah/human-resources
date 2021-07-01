package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.WayOfWorkingService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.WayOfWorking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/WayOfWorking")
public class WayOfWorkingController extends BaseController<WayOfWorkingService, WayOfWorking> {

    private WayOfWorkingService wayOfWorkingService;

    @Autowired
    public WayOfWorkingController(WayOfWorkingService wayOfWorkingService) {
        super(wayOfWorkingService);
        this.wayOfWorkingService = wayOfWorkingService;
    }
}
