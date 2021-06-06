package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.ForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForeignLanguageDao extends JpaRepository<ForeignLanguage,Integer> {
}
