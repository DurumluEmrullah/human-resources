package com.humanresourcesdemo.humanresources.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Job> getAll(){
		
		return this.jobService.getAll();
	}
	
	

}
