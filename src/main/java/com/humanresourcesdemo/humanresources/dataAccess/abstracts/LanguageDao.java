package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language,Integer> {
}
