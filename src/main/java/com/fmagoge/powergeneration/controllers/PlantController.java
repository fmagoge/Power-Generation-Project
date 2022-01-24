package com.fmagoge.powergeneration.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fmagoge.powergeneration.services.PlantService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class PlantController {
	
	
	@Autowired
	private PlantService plantService;	
	
	@GetMapping("/get-plants")
	public ResponseEntity<?> getPlants(){
		return ResponseEntity.ok(plantService.getPlants());
	}
	
	@GetMapping("/get-plants/{id}")
	public ResponseEntity<?> getPlant(@PathVariable long id){
		return ResponseEntity.ok(plantService.getPlant(id));
	}
	
}
