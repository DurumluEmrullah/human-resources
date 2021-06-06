package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Advertisement;
import com.humanresourcesdemo.humanresources.entities.concretes.Education;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface EducationDao extends JpaRepository<Education,Integer> {

    @Query("From Education where cv.cvId=:cvId ")
    List<Education> findByNameOrderByGraduateDateDescAndByCv(Sort sort,int cvId);
}
