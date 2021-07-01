package com.humanresourcesdemo.humanresources.core.api.concretes;

import com.humanresourcesdemo.humanresources.core.business.abstracts.BaseService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.*;


public class BaseController<Service extends BaseService<Entity>,Entity> {

    private Service service;

    public BaseController(Service service){
        this.service=service;
    }


    @GetMapping("/getAll")
    public DataResult<List<Entity>> getAll(){
        return  service.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Entity entity){
        return this.service.add(entity);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Entity entity){
        return this.service.update(entity);
    }
    @DeleteMapping("/delete")
    public Result delete(@RequestBody Entity entity){
        return this.service.delete(entity);
    }
}
