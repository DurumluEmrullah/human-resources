package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolDao extends JpaRepository<School,Integer> {
}
