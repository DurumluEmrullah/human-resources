package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer> {
}
