package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.WayOfWorking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WayOfWorkingDao extends JpaRepository<WayOfWorking,Integer> {
}
