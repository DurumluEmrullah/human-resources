package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae,Integer> {
}
