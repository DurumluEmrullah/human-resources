package com.humanresourcesdemo.humanresources.business.abstracts;

import java.util.List;

import com.humanresourcesdemo.humanresources.entities.concretes.Job;

public interface JobService {

	List<Job> getAll();
}
