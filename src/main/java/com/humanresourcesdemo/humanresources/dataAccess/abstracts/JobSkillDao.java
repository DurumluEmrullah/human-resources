package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.JobSkill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface JobSkillDao extends JpaRepository<JobSkill,Integer> {


    List<JobSkill> getByCv_cvId(int cvId);
}
