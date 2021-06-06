package com.humanresourcesdemo.humanresources.api.controller;

import com.humanresourcesdemo.humanresources.business.abstracts.JobSkillService;
import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;
import com.humanresourcesdemo.humanresources.entities.concretes.JobSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/jobskills")
public class JobSkillsController extends BaseController<JobSkillService, JobSkill> {

    private JobSkillService jobSkillService;

    @Autowired
    public JobSkillsController(JobSkillService jobSkillService) {
        super(jobSkillService);
        this.jobSkillService = jobSkillService;
    }


    @GetMapping("/getbycvid")

    public DataResult<List<JobSkill>> getByCvId(int cvId)
    {
        return this.jobSkillService.getByCvId(cvId);
    }

}
