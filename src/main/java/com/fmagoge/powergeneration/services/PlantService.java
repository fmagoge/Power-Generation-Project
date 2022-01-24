package com.fmagoge.powergeneration.services;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmagoge.powergeneration.model.Plant;
import com.fmagoge.powergeneration.repository.PlantRepository;

@Service
@Transactional
public class PlantService {

	@Autowired
	private PlantRepository plantRepository;
	
	@Autowired 
	private ApacheExcelReadService apachePOIExcelReadService;
	
    public List<Plant> getPlants(){
        List<Plant> entities = plantRepository.findAll();        
        return entities;
    }
    
    public void createPlant(Plant plant) {
    	plantRepository.save(plant);
    }
    
    public void save() throws IOException {
        List<Plant> plantList = null;
        
        if (plantRepository.findAll().size() == 0) {
        	plantList = apachePOIExcelReadService.read();
        	plantRepository.saveAll(plantList);
		}
          
    }
    
    public Plant getPlant(long id) {
		Plant plant = plantRepository.getById(id);
		return plant;
	}
	
}
