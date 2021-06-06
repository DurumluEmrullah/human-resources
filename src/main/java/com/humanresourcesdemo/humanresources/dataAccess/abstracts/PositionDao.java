package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position,Integer> {
}
