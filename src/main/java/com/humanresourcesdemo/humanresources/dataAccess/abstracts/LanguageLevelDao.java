package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.LanguageLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel,Integer> {
}
