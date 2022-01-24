package com.fmagoge.powergeneration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.fmagoge.powergeneration.model.Plant;
import com.fmagoge.powergeneration.repository.PlantRepository;
import com.fmagoge.powergeneration.services.PlantService;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PowerGenerationProjectTests {


	@Autowired(required = true )
	private PlantService plantService;
	
	@Autowired(required = true )
	private PlantRepository plantRepository;
	
	@Test
	@Rollback(false)
	@Order(1)
	public void TestCreatePlant() {
		Plant plant = new Plant();
		plant.setSEQGEN19("1");
		plant.setGENID("WT1");
		plant.setGENSTAT("CN");
		plant.setGENNTAN("19135");
		plant.setPNAME("7-Mile Ridge Wind Project");
		plant.setPSTATABB("AK");
		plant.setYEAR("2019");
		
		plantService.createPlant(plant);
		
		List<Plant> plantList = plantRepository.findAll();
		
		assertThat(plantList).isNotEmpty();
	}
	
	@Test
	@Rollback(false)
	@Order(2)
	public void testReadData() {
		try {
			plantService.save();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Plant> plantList = plantRepository.findAll();
		
		assertThat(plantList).isNotEmpty();
	}
	
	@Test
	@Rollback(false)
	@Order(3)
	public void testGetPlants() {
		
		List<Plant> plantList = plantRepository.findAll();
		
		assertThat(plantList.size()).isGreaterThan(10);
	}
	
	
	
}
