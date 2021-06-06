package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.JobSkill;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface JobSkillDao extends JpaRepository<JobSkill,Integer> {
//    List<JobSkill> getByCurriculumVitae_Id(int cvId);
}
