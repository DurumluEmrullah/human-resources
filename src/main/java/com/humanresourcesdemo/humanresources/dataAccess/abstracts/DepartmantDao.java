package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Departmant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmantDao extends JpaRepository<Departmant,Integer> {
}
