package com.fmagoge.powergeneration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fmagoge.powergeneration.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
	
}
