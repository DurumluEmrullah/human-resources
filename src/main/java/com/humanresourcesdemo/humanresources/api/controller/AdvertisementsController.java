package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.AdvertisementService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.entities.concretes.Advertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.*;

@RestController
@RequestMapping("/api/Advertisements")
public class AdvertisementsController extends BaseController<AdvertisementService,Advertisement> {


    private AdvertisementService advertisementService;

    @Autowired
    public AdvertisementsController(AdvertisementService advertisementService){
        super(advertisementService);
        this.advertisementService=advertisementService;
    }


    @GetMapping("/getallactiveadvertisement")
    public DataResult<List<Advertisement>> getAllActiveAdvertisement(){
        return this.advertisementService.findByIsActiveTrue();
    }

    @GetMapping("/findByIsActiveTrueAndOrderByCreatedDateDesc")
    public DataResult<List<Advertisement>> findByIsActiveTrueAndOrderByCreatedDateDesc(){
        return this.advertisementService.findByIsActiveTrueAndOrderByCreatedDateDesc();
    }

    @GetMapping("/getByCityId")
    public DataResult<List<Advertisement>> getByCityId(@RequestParam int cityId){
        return this.advertisementService.getByCityId(cityId);
    }

    @GetMapping("/getByJobId")
    public DataResult<List<Advertisement>> getByJobId(@RequestParam int jobId){
        return  this.advertisementService.getByJobId(jobId);
    }

    @GetMapping("/getByEmployerId")
    public DataResult<List<Advertisement>> getByEmployerId(@RequestParam int employerId)
    {
        return  this.advertisementService.findByEmployerId(employerId);
    }

    @GetMapping("/getByDescriptionContains")
    public DataResult<List<Advertisement>>getByDescriptionContains(@RequestParam String descriptions)
    {
        return this.advertisementService.getByDescriptionContains(descriptions);
    }

}
