package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education,Integer> {
}
