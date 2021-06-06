package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.WorkerService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.entities.concretes.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
public class WorkersController extends BaseController<WorkerService, Worker> {

    private WorkerService workerService;

    @Autowired
    public WorkersController(WorkerService workerService) {
        super(workerService);
        this.workerService = workerService;
    }

}
