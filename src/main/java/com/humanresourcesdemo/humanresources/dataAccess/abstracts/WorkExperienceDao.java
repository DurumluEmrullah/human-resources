package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Education;
import com.humanresourcesdemo.humanresources.entities.concretes.WorkExperience;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer> {

    @Query("From WorkExperience where cv.cvId=:cvId ")
    List<WorkExperience> findByNameOrderByFinishedDateDescAndCv(Sort sort,int cvId);
}
