package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.WorkerService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
public class WorkersController {

    private WorkerService workerService;

    @Autowired
    public WorkersController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping("/getall")
    public DataResult<List<Worker>> getAll(){
        return this.workerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Worker worker){
        return this.workerService.add(worker);
    }
}
