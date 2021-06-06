package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDao extends JpaRepository<Skill,Integer> {
}
