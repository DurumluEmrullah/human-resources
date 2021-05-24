package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerDao extends JpaRepository<Worker,Integer> {
    Worker findByEmail(String email);
}
