package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.humanresourcesdemo.humanresources.entities.concretes.Job;

public interface JobDao extends JpaRepository<Job, Integer> {

}
