package com.humanresourcesdemo.humanresources.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Jobs")
public class Job {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="jobName")
	private String jobName;

	
	
	public Job() {
		
	}

	public Job(int id, String jobName) {
		
		this.id = id;
		this.jobName = jobName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	
}
