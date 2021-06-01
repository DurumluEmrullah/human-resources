package com.humanresourcesdemo.humanresources.dataAccess.abstracts;

import com.humanresourcesdemo.humanresources.entities.concretes.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementDao extends JpaRepository<Advertisement, Integer> {
}
