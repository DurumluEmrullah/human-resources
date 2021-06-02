package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Advertisement;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.*;

public interface AdvertisementDao extends JpaRepository<Advertisement, Integer> {


    List<Advertisement> findByIsActiveTrue();

    List<Advertisement> getByCity_CityId(int cityId);

    List<Advertisement> getByJob_Id(int id);

    List<Advertisement> getByDescriptionContains(String description);

    @Query("From Advertisement where isActive=:isActive ")
    List<Advertisement> findByOrderByCreatedDateAscAndIsActive(Sort sort, boolean isActive);

    List<Advertisement> findByEmployer_Id(int id);

//    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
//    List<Advertisement> sortedByDeadline


}
