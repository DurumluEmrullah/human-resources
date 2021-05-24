package com.humanresourcesdemo.humanresources.api.controller;

import java.util.List;


import com.humanresourcesdemo.humanresources.core.utilities.results.DataResult;

import com.humanresourcesdemo.humanresources.core.utilities.results.Result;
import com.humanresourcesdemo.humanresources.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.humanresourcesdemo.humanresources.business.abstracts.JobService;
import com.humanresourcesdemo.humanresources.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
	
	private JobService jobService;

	@Autowired
	public JobController(JobService jobService) {
		
		this.jobService = jobService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Job>> getAll(){
		
		return this.jobService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Job job){
		return jobService.add(job);
	}

	
	

}
