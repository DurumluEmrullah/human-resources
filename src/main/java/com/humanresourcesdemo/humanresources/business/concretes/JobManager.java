package com.humanresourcesdemo.humanresources.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanresourcesdemo.humanresources.business.abstracts.JobService;
import com.humanresourcesdemo.humanresources.dataAccess.abstracts.JobDao;
import com.humanresourcesdemo.humanresources.entities.concretes.Job;

@Service
public class JobManager implements JobService {

	private JobDao jobDao;

	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}

	@Override
	public List<Job> getAll() {
		// TODO Auto-generated method stub
		return this.jobDao.findAll();
	}

}