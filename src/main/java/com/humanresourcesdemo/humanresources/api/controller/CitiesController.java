package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.CityService;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.City;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Cities")
public class CitiesController {

    private CityService cityService;

    public CitiesController(CityService cityService){
        this.cityService=cityService;
    }

    @GetMapping("/getAll")
    public DataResult<List<City>> getAll(){

        return  this.cityService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody City city){
        return this.cityService.add(city);
    }
}
