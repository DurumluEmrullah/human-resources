package com.humanresourcesdemo.humanresources.business.concretes;

import java.util.List;
import java.util.Locale;

import com.humanresourcesdemo.humanresources.core.utilities.results.*;
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
	public DataResult<List<Job>> getAll() {

		return new SuccessDataResult<List<Job>>(this.jobDao.findAll(),"Meslekler Listelendi");
	}

	@Override
	public Result add(Job job) {

		Result result=jobValidator(job);
		if(!result.isSuccess()){

			return result;
		}
		result=alreadyExistJob(job);
		if(!result.isSuccess()){
			return result;
		}
		jobDao.save(job);
		return result;
	}

	@Override
	public Result update(Job job) {
		return null;
	}

	@Override
	public Result delete(Job job) {
		return null;
	}


	private Result jobValidator(Job job){
		if(job.getJobName().length()>=4){
			return  new SuccessResult("Yeni pozisyon eklendi");
		}
		return new ErrorResult("Girilen değer en az 4 karakter uzunluğunda olmalı ");
	}

	private Result alreadyExistJob(Job job){
		List<Job> jobs = jobDao.findAll();
		for(int i = 0;i<jobs.toArray().length;i++){
			String jobName =jobs.get(i).getJobName().replace(" ","").toLowerCase(Locale.ROOT);
			if(job.getJobName().replace(" ","").toLowerCase(Locale.ROOT).equals(jobName)){
				return  new ErrorResult("Bu meslek zaten mevcuttur.");
			}

		}
		return new SuccessResult("Yeni pozisyon eklendi.");
	}

}
