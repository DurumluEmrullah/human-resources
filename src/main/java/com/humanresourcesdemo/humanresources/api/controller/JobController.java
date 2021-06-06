package com.humanresourcesdemo.humanresources.api.controller;

import java.util.List;


import com.humanresourcesdemo.humanresources.core.api.concretes.BaseController;
import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;

import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.humanresourcesdemo.humanresources.business.abstracts.JobService;
import com.humanresourcesdemo.humanresources.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController extends BaseController<JobService,Job> {
	
	private JobService jobService;

	@Autowired
	public JobController(JobService jobService) {
		super(jobService);
		this.jobService = jobService;
	}
	


	

}
